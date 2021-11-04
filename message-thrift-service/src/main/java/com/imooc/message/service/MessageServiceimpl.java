package com.imooc.message.service;

import com.imooc.thrift.message.MessageService;
import lombok.extern.log4j.Log4j2;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @ClassName MessageServiceimpl
 * @Description TODO
 * @Author Dream
 * @Date 2021-11-04 22:04
 * @Version 1.0
 **/
@Service
@Log4j2
public class MessageServiceimpl implements MessageService.Iface {
    @Override
    public boolean sendMobileMessage(String mobile, String message) throws TException {
        log.info("我给手机号:{}发送了手机验证码短信:{}",mobile,message);
        return true;
    }

    @Override
    public boolean sendEmailMessage(String email, String message) throws TException {
        log.info("我给邮箱地址：{}发送了邮箱验证码:{}",email,message);
        return true;
    }
}
