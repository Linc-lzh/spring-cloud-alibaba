package com.tulingxueyuan.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@FeignClient(value="stock-nacos",path = "/stock",fallback = StockFeignServiceFallback.class)
public interface StockFeignService {

    @RequestMapping("/reduct")
    public String reduct2();
}
