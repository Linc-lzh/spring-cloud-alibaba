package com.tuling.sentineltokenserver;

import com.alibaba.csp.sentinel.cluster.server.ClusterTokenServer;
import com.alibaba.csp.sentinel.cluster.server.SentinelDefaultTokenServer;
import com.alibaba.csp.sentinel.cluster.server.config.ClusterServerConfigManager;
import com.alibaba.csp.sentinel.cluster.server.config.ServerTransportConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SentinelTokenServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelTokenServerApplication.class, args);
    }

    @Component
    class SentinelTokenServerApplicationRunner implements ApplicationRunner{

        @Override
        public void run(ApplicationArguments args) throws Exception {
            // 独立模式
            ClusterTokenServer tokenServer = new SentinelDefaultTokenServer();
            ClusterServerConfigManager.loadGlobalTransportConfig(new ServerTransportConfig()
                    .setIdleSeconds(600)
                    .setPort(11111));
            // 启动服务
            tokenServer.start();
        }
    }

}
