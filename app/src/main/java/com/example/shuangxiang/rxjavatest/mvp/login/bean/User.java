package com.example.shuangxiang.rxjavatest.mvp.login.bean;

/**
 * Created by shuang.xiang on 2016/8/29.
 */
public class User {
    private String mFirstName;
    private String mLastName;

    public User(String firstName, String lastName) {
        this. mFirstName = firstName;
        this. mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

}
