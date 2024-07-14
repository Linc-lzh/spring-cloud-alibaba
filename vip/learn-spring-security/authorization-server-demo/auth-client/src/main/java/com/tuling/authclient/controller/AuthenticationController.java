package com.tuling.authclient.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    /**
     * http://spring-oauth-client:9001/token
     * @param oAuth2AuthorizedClient
     * @return
     */
    @GetMapping("/token")
    @ResponseBody
    public OAuth2AuthorizedClient token(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        // 通过OAuth2AuthorizedClient对象获取到客户端和令牌相关的信息，然后直接返回给前端页面
        return oAuth2AuthorizedClient;
    }
}
