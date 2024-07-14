package com.tuling.authserverjdbc.service;


import com.tuling.authserverjdbc.model.SysUserEntity;

public interface SysUserService {

    /**
     *
     * 根据用户名查询用户信息
     */
    SysUserEntity selectByUsername(String username);


}
