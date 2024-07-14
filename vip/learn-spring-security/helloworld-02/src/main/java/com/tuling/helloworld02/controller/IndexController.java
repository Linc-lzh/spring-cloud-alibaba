package com.tuling.helloworld02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String home(){
        return "home page";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }

    @GetMapping("/user/index3")
    public String index3(){
        return "index3";
    }

    @GetMapping("/order/index4")
    public String index4(){
        return "index4";
    }

}
