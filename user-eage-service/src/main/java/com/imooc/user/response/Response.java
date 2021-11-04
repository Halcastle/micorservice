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

    public static final Response USERNAME_PASSWORD_INVALID = new Response("1001", "username or password is invalid!");

    public static final Response MOBILE_OR_EMAIL_REQUIRED = new Response("1002", "mobile or email is required!");

    public static final Response SEND_VERIFYCODE_FAILED = new Response("1003", "send verifycode failed!");

    public static final Response VERIFYCODE_INVALID = new Response("1004", "verifycode invalid!");

    public static final Response SUCCESS = new Response();

    private String code;

    private String message;

    public Response() {
        this.code = "0";
        this.message = "success";
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Response exception(Exception e){
        return new Response("9999",e.getMessage());
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
