package com.tulingxueyuan.order.feign;

import org.springframework.stereotype.Component;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Component
public class StockFeignServiceFallback implements StockFeignService {
    @Override
    public String reduct2() {
        return "降级啦！！！";
    }
}
