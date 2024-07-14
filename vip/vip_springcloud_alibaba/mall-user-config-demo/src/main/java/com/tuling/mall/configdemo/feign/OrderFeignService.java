package com.tuling.mall.configdemo.feign;

import com.tuling.common.utils.R;
import com.tuling.common.dto.OrderDTO;

import feign.Headers;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fox
 *
 *
 */
@FeignClient(value = "mall-order",path = "/order")
public interface OrderFeignService {

    @RequestMapping("/findOrderByUserId/{userId}")
    R findOrderByUserId(@PathVariable("userId") Integer userId);


}

