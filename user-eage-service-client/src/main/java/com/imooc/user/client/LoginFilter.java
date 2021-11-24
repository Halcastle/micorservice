package com.imooc.user.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.imooc.user.dto.UserDTO;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName LoginFilter
 * @Description TODO
 * @Author Dream
 * @Date 2021-11-05 0:03
 * @Version 1.0
 **/
public abstract class LoginFilter implements Filter {

    private static Cache<String,UserDTO> cache =
            CacheBuilder.newBuilder().maximumSize(10000)
            .expireAfterWrite(3, TimeUnit.MINUTES).build();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("token")) {
                        token = c.getValue();
                    }
                }
            }
        }

        UserDTO userDTO = null;
        if (StringUtils.isNotBlank(token)) {
            userDTO = cache.getIfPresent(token);
            if(userDTO==null){
                userDTO = requestUserInfo(token);
                if(userDTO!=null){
                    cache.put(token,userDTO);
                }
            }
        }
        if(userDTO == null){
            response.sendRedirect("http://127.0.0.1:8082/user/login");
            return ;
        }

        
        login(request,response,userDTO);
        
        filterChain.doFilter(request,response);
    }

    protected abstract void login(HttpServletRequest request, HttpServletResponse response, com.imooc.user.dto.UserDTO userDTO);


    private com.imooc.user.dto.UserDTO requestUserInfo(String token) {
        String url = "http://127.0.0.1:8082/user/authentication";
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("token",token);
        InputStream content = null ;
        try {
            HttpResponse response = client.execute(httpPost);
            if(response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK){
                throw new RuntimeException("request user info failed ! StatusLine :"+response.getStatusLine());
            }
            content = response.getEntity().getContent();
            byte[] temp = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int len = 0;
            while ((len = content.read(temp))>0){
                sb.append(new String(temp,0,len));
            }

            UserDTO userDTO = new ObjectMapper().readValue(sb.toString(),UserDTO.class);
            return userDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(content!=null){
                try {
                    content.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public void destroy() {

    }
}
