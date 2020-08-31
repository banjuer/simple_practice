package xyz.banjuer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.banjuer.entity.AcceptorEntity;
import xyz.banjuer.tool.OkHttpUtil;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class PaxosService {

    @Value("${paxos.acceptor}")
    private String urls;

    @Value("${server.port}")
    private int port;

    private int majorityN;
    private List<String> acceptors;


    @PostConstruct
    public void init() {
        String[] urlArr = this.urls.split(",");
        this.majorityN = urlArr.length / 2 + 1;
        this.acceptors = Arrays.asList(urlArr);
    }

    public int getThisPort() {
        return port;
    }

    public List<String> getAcceptors() {
        return acceptors;
    }

    public int getMajorityN() {
        return majorityN;
    }

    public String instanceDiscover(String instance) {
        try {
            return OkHttpUtil.get(instance + "/rpc/test");
        } catch (Exception e) {
            log.error(e.toString());
            return "ng";
        }
    }

    public AcceptorEntity acceptorAccept(String instance, int e, String v) {
        try {
            String text = OkHttpUtil.get(instance + "/rpc/acceptor/accept?e=" + e + "&v=" + v);
            return JSON.parseObject(text, AcceptorEntity.class);
        } catch (Exception exception) {
            log.error(exception.toString());
            return new AcceptorEntity();
        }
    }

    public AcceptorEntity acceptorPrepare(String instance, int e) {
        try {
            String text = OkHttpUtil.get(instance + "/rpc/acceptor/prepare?e=" + e);
            return JSON.parseObject(text, AcceptorEntity.class);
        } catch (Exception exception) {
            log.error(exception.toString());
            return new AcceptorEntity();
        }
    }
}
