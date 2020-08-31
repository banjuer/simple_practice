package xyz.banjuer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.banjuer.entity.AcceptorEntity;
import xyz.banjuer.entity.ProposerEntity;
import xyz.banjuer.tool.EmptyUtils;
import xyz.banjuer.tool.OkHttpUtil;
import xyz.banjuer.tool.SqliteHelper;

@Slf4j
@RestController
@RequestMapping("/rpc")
public class PaxosRpcServer {

    @Autowired
    private PaxosService paxosService;

    @GetMapping("test")
    public String test() {
        return "ok";
    }

    @GetMapping("acceptor/prepare")
    public synchronized AcceptorEntity acceptorPrepareSrv(int e) {
        AcceptorEntity cfg = this.getAcceptorCfg();
        this.byzantineAssert(cfg.p_e >= 0 && cfg.p_e >= cfg.a_e);
        if (e > cfg.p_e) {
            cfg.op_flag = true;
            SqliteHelper.getDefaultInstance().update("update config set p_e=? where id=?", new Object[]{e, cfg.id});
        }
        return cfg;
    }

    @GetMapping("acceptor/accept")
    public synchronized AcceptorEntity acceptorAcceptSrv(int e, String v) {
        AcceptorEntity cfg = this.getAcceptorCfg();
        this.byzantineAssert(cfg.p_e >= 0 && cfg.p_e >= cfg.a_e && e <= cfg.p_e);
        if (e == cfg.p_e) {
            if (e == cfg.a_e) {
                this.byzantineAssert(cfg.a_v.equals(v));
            } else {
                SqliteHelper.getDefaultInstance().update("update config set a_e=?,a_v=? where id=?", new Object[]{e, v, cfg.id});
            }
            cfg.op_flag = true;
        } else {
            cfg.op_flag = false;
        }
        return cfg;
    }

    @GetMapping("/proposer/propose")
    public ProposerEntity proposerPropose(String v, int e) {
        ProposerEntity proposer = new ProposerEntity();
        Map<String, Object> prepare = this.sendPrepare2Majority(e);
        int p_next_e = Integer.parseInt(prepare.get("p_next_e").toString());
        List<String> p_ok_list = (List) prepare.get("p_ok_list");
        String max_a_v = prepare.get("max_a_v") == null ? null : prepare.get("max_a_v").toString();
        if (p_ok_list.size() >= paxosService.getMajorityN()) {
            String accept_v = v;
            boolean help_flag = false;
            if (max_a_v != null) {
                accept_v = max_a_v;
                help_flag = true;
            }

            Map<String, Object> accept = this.sendAccept(p_ok_list, e, accept_v);
            int a_next_e = Integer.parseInt(accept.get("a_next_e").toString());
            List<String> a_ok_list = (List) accept.get("a_ok_list");
            if (a_ok_list.size() >= paxosService.getMajorityN()) {
                proposer.chosen_flag = true;
                proposer.help_chosen_flag = help_flag;
                proposer.chosen_v = accept_v;
            } else {
                proposer.chosen_flag = false;
                proposer.help_chosen_flag = false;
                proposer.chosen_v = null;
                proposer.next_e = Math.max(a_next_e, p_next_e);
            }
        } else {
            proposer.chosen_flag = false;
            proposer.help_chosen_flag = false;
            proposer.chosen_v = null;
            proposer.next_e = p_next_e;
        }

        return proposer;
    }

    private Map<String, Object> sendAccept(List<String> okInstance, int e, String v) {
        Map<String, Object> ret = new HashMap();
        int a_next_e = e + 1;
        List<String> a_ok_list = new ArrayList(okInstance.size());
        for (String instance : okInstance) {
            log.info("server {} send accept {},e:{},v:{}", paxosService.getThisPort(), instance, e, v);
            AcceptorEntity acceptor = this.paxosService.acceptorAccept(instance, e, v);
            log.info("server {} receive accept result: {}", paxosService.getThisPort(), JSON.toJSON(acceptor));
            if (acceptor.op_flag) {
                a_ok_list.add(instance);
            }
        }

        ret.put("a_ok_list", a_ok_list);
        ret.put("a_next_e", a_next_e);
        return ret;
    }

    private Map<String, Object> sendPrepare2Majority(int e) {
        Map<String, Object> ret = new HashMap();
        List<String> okList = new ArrayList(paxosService.getAcceptors().size());
        String max_a_v = null;
        for (String instance : paxosService.getAcceptors()) {
            log.info("server {} send prepare {},e:{}", paxosService.getThisPort(), instance, e);
            AcceptorEntity acceptor = this.paxosService.acceptorPrepare(instance, e);
            log.info("server {} receive prepare result {}", paxosService.getThisPort(), JSON.toJSON(acceptor));
            if (acceptor.op_flag) {
                okList.add(instance);
                if (EmptyUtils.isNotEmpty(acceptor.a_v)) {
                    max_a_v = acceptor.a_v;
                }
            }
        }

        ret.put("p_next_e", e + 1);
        ret.put("p_ok_list", okList);
        ret.put("max_a_v", max_a_v);
        return ret;
    }

    private AcceptorEntity getAcceptorCfg() {
        AcceptorEntity config = new AcceptorEntity();
        SqliteHelper.getDefaultInstance().query("select * from config limit 1", null, (rs) -> {
            while (rs.next()) {
            String id = rs.getString(1);
            String cfg = rs.getString(2);
            int p_e = rs.getInt(3);
            int a_e = rs.getInt(4);
            String a_v = rs.getString(5);
            config.id = id;
            config.cfg = cfg;
            config.p_e = p_e;
            config.a_e = a_e;
            config.a_v = a_v;
            }
        });
        return config;
    }

    /**
     * 拜占庭错误paxos实例停机
     */
    private void byzantineAssert(boolean byzantineFlag) {
        if (!byzantineFlag) {
            log.error("paxos got a byzantine error, instance will exit");
            for (String acceptor: paxosService.getAcceptors()) {
                OkHttpUtil.post(acceptor + "/actuator/shutdown", null);
            }
        }

    }
}
