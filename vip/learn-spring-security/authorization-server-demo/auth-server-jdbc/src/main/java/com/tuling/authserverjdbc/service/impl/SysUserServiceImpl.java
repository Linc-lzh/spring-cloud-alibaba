package com.tuling.authserverjdbc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuling.authserverjdbc.mapper.SysUserMapper;
import com.tuling.authserverjdbc.model.SysUserEntity;
import com.tuling.authserverjdbc.service.SysUserService;
import org.springframework.stereotype.Service;


@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {


    @Override
    public SysUserEntity selectByUsername(String username) {
        LambdaQueryWrapper<SysUserEntity> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUserEntity::getUsername,username);
        return this.getOne(lambdaQueryWrapper);
    }


}
