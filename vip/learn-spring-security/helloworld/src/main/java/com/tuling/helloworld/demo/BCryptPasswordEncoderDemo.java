package com.tuling.helloworld.demo;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptPasswordEncoderDemo {

    public static void main(String[] args) {
        //加密
        String passwd = BCrypt.hashpw("123456",BCrypt.gensalt());
        System.out.println(passwd);

        //校验
        boolean checkpw = BCrypt.checkpw("123456", "$2a$10$KfdyA40l4iElg7ox9GLR9.4ujIv6q9EfOpcRwrM7zYQrDHZuYoIui");
        System.out.println(checkpw);

    }
}
