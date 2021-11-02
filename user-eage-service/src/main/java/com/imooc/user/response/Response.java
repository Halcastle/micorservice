package com.imooc.user.response;

import java.io.Serializable;

/**
 * @ClassName Response
 * @Description TODO
 * @Author pwang6
 * @Date 2021/11/2 11:01
 * @Version 1.0
 **/
public class Response implements Serializable {

    public static final Response USERNAME_PASSWORD_INVALID = new Response("1001","username or password is invalid!");

    private String code;

    private String message;

    public Response(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
