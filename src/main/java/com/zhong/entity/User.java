package com.zhong.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;

@Alias("UserEntity")
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private int age;
    private String name;
    private List<User> userlist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

}