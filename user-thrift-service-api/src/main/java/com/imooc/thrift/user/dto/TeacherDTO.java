package com.imooc.thrift.user.dto;

/**
 * @ClassName TeacherDTO
 * @Description TODO
 * @Author Dream
 * @Date 2021-11-23 10:56
 * @Version 1.0
 **/
public class TeacherDTO extends com.imooc.user.dto.UserDTO {

    private String intro;
    private int stars;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
