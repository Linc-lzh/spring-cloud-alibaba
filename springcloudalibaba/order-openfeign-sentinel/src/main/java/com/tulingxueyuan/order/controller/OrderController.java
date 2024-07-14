package com.tulingxueyuan.order.controller;

import com.tulingxueyuan.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    StockFeignService stockFeignService;

    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功!");
        String s = stockFeignService.reduct2();


        return "Hello Feign"+s;
    }
}
