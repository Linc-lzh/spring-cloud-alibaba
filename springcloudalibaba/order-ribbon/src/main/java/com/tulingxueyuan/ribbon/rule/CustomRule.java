package com.tulingxueyuan.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class CustomRule extends AbstractLoadBalancerRule {

    @Override
    public Server choose(Object key) {
        ILoadBalancer loadBalancer = this.getLoadBalancer();

        // 获得当前请求的服务的实例
        List<Server> reachableServers = loadBalancer.getReachableServers();

        int random=ThreadLocalRandom.current().nextInt(reachableServers.size());

        Server server = reachableServers.get(random);
//        if(server.isAlive()){
//            return null;
//        }

        return server;
    }


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
