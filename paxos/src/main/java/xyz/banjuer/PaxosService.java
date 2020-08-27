package xyz.banjuer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.banjuer.entity.AcceptorEntity;
import xyz.banjuer.tool.OkHttpUtil;

@Slf4j
@Service
public class PaxosService {

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
            String text = OkHttpUtil.get(instance + "/rpc/acceptor/accept?e" + e + "&v=" + v);
            return JSON.parseObject(text, AcceptorEntity.class);
        } catch (Exception exception) {
            log.error(exception.toString());
            return new AcceptorEntity();
        }
    }

    public AcceptorEntity acceptorPrepare(String instance, int e) {
        try {
            String text = OkHttpUtil.get(instance + "/rpc/acceptor/prepare?e" + e);
            return JSON.parseObject(text, AcceptorEntity.class);
        } catch (Exception exception) {
            log.error(exception.toString());
            return new AcceptorEntity();
        }
    }
}
