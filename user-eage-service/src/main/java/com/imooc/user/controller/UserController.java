package com.imooc.user.controller;

import com.imooc.thrift.user.UserInfo;
import com.imooc.user.dto.UserDTO;
import com.imooc.user.redis.RedisClient;
import com.imooc.user.response.LoginResponse;
import com.imooc.user.response.Response;
import com.imooc.user.thrift.ServiceProvider;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author pwang6
 * @Date 2021/11/2 10:46
 * @Version 1.0
 **/
@Controller
public class UserController {

    @Autowired
    private ServiceProvider serviceProvider;

    @Autowired
    private RedisClient redisClient;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestParam("username") String username,
                      @RequestParam("password") String password){

        //1.验证用户名密码
        UserInfo userInfo = null ;
        try {
            userInfo = serviceProvider.getUserService().getUserByName(username);

        } catch (TException e) {
            e.printStackTrace();
            return Response.USERNAME_PASSWORD_INVALID;
        }
        if(userInfo == null){
            return Response.USERNAME_PASSWORD_INVALID;
        }
        if(!userInfo.getPassword().equalsIgnoreCase(md5(password))){
            return Response.USERNAME_PASSWORD_INVALID;
        }
        //2.生成tocken
        String token = genToken();
        //3.缓存用户
        redisClient.set(token,toDTO(userInfo),3600);
        return new LoginResponse(token);
    }

    public Response sendVerifyCode(@RequestParam(value = "mobile",required = false) String mobile,
                                   @RequestParam(value = "email",required = false) String email){
        if(StringUtils.isNotBlank(mobile)){

        }else if(StringUtils.isNotBlank(email)){

        }else{
            return Response.MOBILE_OR_EMAIL_REQUIRED;
        }
    }

    public Response register(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam(value="mobile",required = false) String mobile,
                             @RequestParam(value="email",required = false) String email,
                             @RequestParam(value="verifyCode",required = false) String verifyCode){
        if(StringUtils.isBlank(mobile)&&StringUtils.isBlank(email)){
            return Response.MOBILE_OR_EMAIL_REQUIRED;
        }

        if(StringUtils.isNotBlank(mobile)){

        }else{

        }

    }

    private UserDTO toDTO(UserInfo userInfo) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userInfo,userDTO);
        return userDTO;
    }

    private String genToken() {
        return randomCode("0123456789abcdefghijklmnopqrstuvwxyz",32);
    }

    private String randomCode(String s,int size) {
        StringBuilder result = new StringBuilder(size);
        Random random = new Random();
        for(int i = 0;i<size;i++){
            int loc = random.nextInt(s.length());
            result.append(s.charAt(loc));
        }
        return result.toString();
    }

    private String md5(String password){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(password.getBytes("UTF-8"));
            return HexUtils.toHexString(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
