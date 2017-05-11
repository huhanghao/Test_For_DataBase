package com.example.huhanghao.test_for_greendao.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by huhanghao on 2017/5/9.
 */

public class UserRealm extends RealmObject{
    private String name;
    private int age;

    public RealmList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(RealmList<Dog> dogs) {
        this.dogs = dogs;
    }

    private RealmList<Dog> dogs;


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
