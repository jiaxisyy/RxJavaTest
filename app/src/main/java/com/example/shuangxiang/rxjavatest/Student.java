package com.example.shuangxiang.rxjavatest;

/**
 * Created by shuang.xiang on 2016/7/9.
 */
public class Student {
    String name;
    String courses;
    int id;

    public Student(String name, String courses, int id) {
        this.name = name;
        this.courses = courses;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
