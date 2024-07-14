package com.tulingxueyuan.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Configuration
public class RibbonRandomRuleConfig {

    // 方法名一定要叫iRule
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
