package com.tulingxueyuan.order.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@FeignClient(name="product-service",path ="/product")
public interface ProductFeignService {


    @RequestLine("GET /{id}")     //  @RequestLine
    public String get(@Param("id") Integer id);  // @Param
}
