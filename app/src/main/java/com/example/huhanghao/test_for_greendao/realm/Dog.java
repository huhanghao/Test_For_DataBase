package com.example.huhanghao.test_for_greendao.realm;


import io.realm.RealmObject;

/**
 * Created by huhanghao on 2017/5/9.
 */

public class Dog extends RealmObject {
    private String name;
    private int age;
    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
