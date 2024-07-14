package com.tuling.mall.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tuling.common.utils.R;
import org.springframework.web.client.RestTemplate;

/**
 * 
 *
 * @author fox
 * @email 2763800211@qq.com
 * @date 2021-01-28 15:53:24
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/findOrderByUserId/{id}")
    public R  findOrderByUserId(@PathVariable("id") Integer id) {
        log.info("根据userId:"+id+"查询订单信息");
        // 方式1：restTemplate调用,url写死
        //String url = "http://localhost:8020/order/findOrderByUserId/"+id;


        //方式2： 利用负载均衡器获取mall-order服务列表
        //ServiceInstance serviceInstance = loadBalancerClient.choose("mall-order");
        //String url = String.format("http://%s:%s/order/findOrderByUserId/%s",serviceInstance.getHost(),serviceInstance.getPort(),id);

        //利用@LoadBalanced，restTemplate需要添加@LoadBalanced注解
        String url = "http://mall-order/order/findOrderByUserId/"+id;

        R result = restTemplate.getForObject(url,R.class);

        //orderService.findOrderByUserId(id);
        return result;
    }



}
