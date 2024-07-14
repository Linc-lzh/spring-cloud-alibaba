package com.tulingxueyuan.order.feign;

import com.tulingxueyuan.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
/*
2. 添加feign接口和方法
* name 指定调用rest接口所对应的服务名
* path 指定调用rest接口所在的StockController指定的@RequestMapping
* */
@FeignClient(name="stock-service",path ="/stock",configuration = FeignConfig.class)
public interface StockFeignService {

    // 声明需要调用的rest接口对应的方法
    @RequestMapping("/reduct")
    String reduct();
}


/*
* @RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/reduct/{id}")
    public String reduct(@PathVarible) throws InterruptedException {
        System.out.println("扣减库存");
        return "扣减库存:"+port;
    }

}

* */