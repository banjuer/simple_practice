package xyz.banjuer;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import xyz.banjuer.entity.ProposerEntity;
import xyz.banjuer.tool.SqliteHelper;

@Slf4j
@Component
public class PaxosProcessor implements ApplicationRunner {

    @Autowired
    private PaxosRpcServer rpcServer;
    @Autowired
    private PaxosService paxosService;
    @Value("${paxos.instance}")
    private String urls;

    public PaxosProcessor() {
    }

    @Override
    public void run(ApplicationArguments args) {
        String[] id = new String[1];
        SqliteHelper.getDefaultInstance().query("select id from config limit 1", null, (rs) -> {
            id[0] = rs.getString(1);
        });
        (new Thread(new LeaderChosen(this.rpcServer, this.paxosService, Arrays.asList(this.urls.split(",")), id[0]))).start();
    }

    static class LeaderChosen implements Runnable {
        private PaxosRpcServer rpcServer;
        private PaxosService paxosService;
        private List<String> instances;
        private String proper_v;

        @SneakyThrows
        @Override
        public void run() {
            this.waitAllOnline();
            this.mustChosen(this.proper_v);
        }

        private void mustChosen(String chosen_v) {
            int e = 1;
            while(true) {
                ProposerEntity proposerEntity = this.rpcServer.proposerPropose(chosen_v, e);
                log.info("first proposer propose result:" + JSON.toJSONString(proposerEntity));
                if (proposerEntity.chosen_flag) {
                    log.info("chosen result: " + proposerEntity.chosen_v);
                    SqliteHelper.getDefaultInstance().update("update config set a_v=? where id=?", new Object[]{proposerEntity.chosen_v, this.proper_v});
                    return;
                }
                e = proposerEntity.next_e;
            }
        }

        private void waitAllOnline() throws InterruptedException {
            boolean allOnline = false;
            while(!allOnline) {
                int online = 0;
                for (String instance : this.instances) {
                    String text = this.paxosService.instanceDiscover(instance);
                    if ("ok".equals(text)) {
                        ++online;
                    } else {
                        log.warn("wait " + instance + " online");
                    }
                }
                if (online == this.instances.size()) {
                    allOnline = true;
                } else {
                    TimeUnit.SECONDS.sleep(2L);
                }
            }

        }

        public LeaderChosen(PaxosRpcServer rpcServer, PaxosService paxosService, List<String> instances, String proper_v) {
            this.rpcServer = rpcServer;
            this.paxosService = paxosService;
            this.instances = instances;
            this.proper_v = proper_v;
        }
    }
}
