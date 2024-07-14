package com.tuling.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${user.name}")
    public String name;

    @RequestMapping("/show")
    public String show(){
        return name;
    }
}
