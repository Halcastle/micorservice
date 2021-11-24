package com.imooc.course.dto;

import com.imooc.thrift.user.dto.TeacherDTO;

import java.io.Serializable;

/**
 * @ClassName CourseDTO
 * @Description TODO
 * @Author Dream
 * @Date 2021-11-23 10:20
 * @Version 1.0
 **/
public class CourseDTO implements Serializable {

    private int id;
    private String title;
    private String decription;
    private TeacherDTO teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }
}
