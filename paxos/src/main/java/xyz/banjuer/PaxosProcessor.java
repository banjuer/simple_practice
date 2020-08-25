package xyz.banjuer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PaxosProcessor {

    @Value("${paxos.instance}")
    private String instanceUrls;

    @Value("${server.port}")
    private int port;

    private List<String> instances;

    @PostConstruct
    public void init() {
        String[] servers = instanceUrls.split(",");
        instances = new ArrayList<>(servers.length);
        for(String server: servers){
            String[] split = server.split(":");
            if (Integer.parseInt(split[2]) != port) {
                instances.add(server);
            }
        }
        System.out.println("port:" + port + "已启动. 待通讯实例:" + instances);
    }


}
