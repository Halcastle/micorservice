package com.imooc.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.imooc.course.dto.CourseDTO;
import com.imooc.course.service.ICourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author Dream
 * @Date 2021-11-24 16:35
 * @Version 1.0
 **/
@Controller
@RequestMapping("/course")
public class CourseController {

    @Reference
    private ICourseService courseService;

    @RequestMapping(value="/courseList",method = RequestMethod.GET)
    @ResponseBody
    public List<CourseDTO> courseList(HttpServletRequest request){
        com.imooc.user.dto.UserDTO user = (com.imooc.user.dto.UserDTO) request.getAttribute("user");
        System.out.println("--------userDTO-----------"+user);
        return courseService.courseList();
    }
}
