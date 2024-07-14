package com.tuling.mall.feigndemo.feign;

import com.tuling.common.utils.R;
import com.tuling.common.dto.OrderDTO;

import com.tuling.mall.feigndemo.config.FeignConfig;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fox
 *
 *
 */

//FeignConfig局部配置，让指定的微服务生效，在@FeignClient 注解中指定configuration
//@FeignClient(value = "mall-order",path = "/order",configuration = FeignConfig.class)
@FeignClient(value = "mall-order",path = "/order")
public interface OrderFeignService {

    /**
     *  1. openfeign传递restful参数
     *  方法要求：
     *    返回值： 要对应
     *    方法名：随意
     *    参数： 要对应的注解
     *  方法上添加springmvc
     * @param userId
     * @return
     */
    @RequestMapping("/findOrderByUserId/{userIdsxxx}")
    R findOrderByUserIdxxxx(@PathVariable("userIdsxxx") Integer userId);

//    @RequestLine("GET /findOrderByUserId/{userId}")
//    R findOrderByUserId(@Param("userId") Integer userId);


    /**
     *  2. openfeign传递普通表单参数
     *
     *  在OpenFeign中方法参数前如果没有注解，默认添加@RequestBody注解,最多只能存在一个不带注解的参数
     *
     *  普通表单参数必须添加@RequestParam注解，如果变量名和参数名对应可以不写name
     *
     * @param userId
     * @param commodityCode
     * @return
     */
    @RequestMapping(path = "/orderInfo")
    R findOrder(@RequestParam Integer userId, @RequestParam String commodityCode);

    @RequestMapping(path = "/orderInfo")
    R findOrder(@SpringQueryMap OrderDTO orderDTO);


    /**
     * 3. openfeign传递请求体参数
     * 在OpenFeign中方法参数前如果没有注解，默认添加@RequestBody注解,最多只能存在一个不带注解的参数
     *
     * @param orderDTO
     * @return
     */
    @RequestMapping(path = "/findOrderByUserIdAndCode",headers = {"Content-Type=application/json;charset=UTF-8"})
    //@RequestMapping(path = "/findOrderByUserIdAndCode")
    R findOrderByUserIdAndCode(OrderDTO orderDTO);

    @RequestMapping(path = "/findOrderByUserIdAndCode")
    String findOrderByUserIdAndCode2(OrderDTO orderDTO);



}

