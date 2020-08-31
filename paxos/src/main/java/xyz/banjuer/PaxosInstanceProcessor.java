package xyz.banjuer;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import xyz.banjuer.entity.ProposerEntity;
import xyz.banjuer.tool.SqliteHelper;

@Slf4j
@Component
public class PaxosInstanceProcessor implements ApplicationRunner {

    @Autowired
    private PaxosRpcServer rpcServer;
    @Autowired
    private PaxosService paxosService;

    public PaxosInstanceProcessor() {
    }

    @Override
    public void run(ApplicationArguments args) {
        String[] id = new String[1];
        SqliteHelper.getDefaultInstance().query("select id from config limit 1", null, (rs) -> id[0] = rs.getString(1));
        log.info("server {} suggested chosen v:{}", paxosService.getThisPort(), id[0]);
        (new Thread(new LeaderChosen(this.rpcServer, this.paxosService, paxosService.getAcceptors(), id[0]))).start();
    }

    @Slf4j
    static class LeaderChosen implements Runnable {
        private PaxosRpcServer rpcServer;
        private PaxosService paxosService;
        private List<String> acceptors;
        private String proper_v;

        @SneakyThrows
        @Override
        public void run() {
            this.waitMajorityOnline();
            this.mustChosen(this.proper_v);
        }

        private void mustChosen(String chosen_v) {
            int e = 1;
            while(true) {
                ProposerEntity proposerEntity = this.rpcServer.proposerPropose(chosen_v, e);
                log.info("server {} first proposer propose result:{}", paxosService.getThisPort(), JSON.toJSONString(proposerEntity));
                if (proposerEntity.chosen_flag) {
                    log.info("server {} chosen result:{} ", paxosService.getThisPort(), proposerEntity.chosen_v);
                    SqliteHelper.getDefaultInstance().update("update config set a_v=? where id=?", new Object[]{proposerEntity.chosen_v, this.proper_v});
                    return;
                }
                e = proposerEntity.next_e;
            }
        }

        private void waitMajorityOnline() throws InterruptedException {
            boolean majorityOnline = false;
            while(!majorityOnline) {
                int online = 0;
                for (String acceptor : this.acceptors) {
                    String text = this.paxosService.instanceDiscover(acceptor);
                    if ("ok".equals(text)) {
                        ++online;
                    } else {
                        log.warn("server {} wait {} online", paxosService.getThisPort(), acceptor);
                    }
                }
                if (online >= paxosService.getMajorityN()) {
                    majorityOnline = true;
                } else {
                    TimeUnit.SECONDS.sleep(2L);
                }
            }

        }

        public LeaderChosen(PaxosRpcServer rpcServer, PaxosService paxosService, List<String> acceptors, String proper_v) {
            this.rpcServer = rpcServer;
            this.paxosService = paxosService;
            this.acceptors = acceptors;
            this.proper_v = proper_v;
        }
    }
}
