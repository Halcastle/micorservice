package com.imooc.course.filter;

import com.imooc.user.client.LoginFilter;
import com.imooc.user.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CourseFilter
 * @Description TODO
 * @Author Dream
 * @Date 2021-11-24 16:40
 * @Version 1.0
 **/
public class CourseFilter extends LoginFilter {
    @Override
    protected void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO) {
        request.setAttribute("user",userDTO);
    }
}
