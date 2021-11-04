package com.imooc.user.response;

/**
 * @ClassName LoginResponse
 * @Description TODO
 * @Author pwang6
 * @Date 2021/11/3 15:57
 * @Version 1.0
 **/
public class LoginResponse extends Response {

    private String token;

    public LoginResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
