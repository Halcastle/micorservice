package com.imooc.user.service;

import com.imooc.thrift.user.UserInfo;
import com.imooc.thrift.user.UserService;
import org.apache.thrift.TException;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Dream
 * @Date 2021-11-01 22:59
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService.Iface {
    @Override
    public UserInfo getUserById(int id) throws TException {
        return null;
    }

    @Override
    public UserInfo getUserByName(String username) throws TException {
        return null;
    }

    @Override
    public void registerUser(UserInfo userInfo) throws TException {

    }
}
