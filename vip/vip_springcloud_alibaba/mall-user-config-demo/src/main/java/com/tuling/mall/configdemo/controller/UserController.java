package com.tuling.mall.configdemo.controller;


import com.tuling.common.utils.R;

import com.tuling.common.dto.OrderDTO;
import com.tuling.mall.configdemo.feign.OrderFeignService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * 
 *
 * @author fox
 * @email 2763800211@qq.com
 * @date 2021-01-28 15:53:24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    OrderFeignService orderFeignService;

    @RequestMapping(value = "/findOrderByUserId/{id}")
    public R  findOrderByUserId(@PathVariable("id") Integer id) {
        //openFeign调用
        R result = orderFeignService.findOrderByUserId(id);
        return result;
    }


}