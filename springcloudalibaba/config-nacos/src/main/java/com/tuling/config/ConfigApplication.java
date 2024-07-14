package com.tuling.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);
        while (true) {
            String userName = applicationContext.getEnvironment().getProperty("user.name");
            String userAge = applicationContext.getEnvironment().getProperty("user.age");
            String config = applicationContext.getEnvironment().getProperty("user.config");
            System.err.println("user name :" + userName + "; age: " + userAge+";config:"+config);
            TimeUnit.SECONDS.sleep(1);
        }
        // nacos客户端 每10ms去 注册中心进行判断，  根据MD5
    }
}
