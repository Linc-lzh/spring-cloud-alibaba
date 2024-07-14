package com.tuling.mall.feigndemo.controller;


import com.tuling.common.utils.R;

import com.tuling.common.dto.OrderDTO;
import com.tuling.mall.feigndemo.feign.OrderFeignService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.openfeign.SpringQueryMap;
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
        //openFeign调用   远程调用
        R result = orderFeignService.findOrderByUserIdxxxx(id);
        return result;
    }


    @RequestMapping(value = "/orderInfo")
    public R  findOrder(Integer userId,String commodityCode) {
        //openFeign调用
        //R result = orderFeignService.findOrder(userId,commodityCode);
        R result = orderFeignService.findOrder(new OrderDTO(userId,commodityCode));
        return result;
    }

    @RequestMapping(value = "/findOrderByUserIdAndCode")
    public R  findOrderByUserIdAndCode(@RequestBody OrderDTO orderDTO) {
        //openFeign调用
        R result = orderFeignService.findOrderByUserIdAndCode(orderDTO);
        return result;
    }

    @RequestMapping(value = "/findOrderByUserIdAndCode2")
    public String findOrderByUserIdAndCode2(@RequestBody OrderDTO orderDTO) {
        //openFeign调用
        //R result = orderFeignService.findOrderByUserIdAndCode(orderDTO);
        String result = orderFeignService.findOrderByUserIdAndCode2(orderDTO);
        return result;
    }


}
