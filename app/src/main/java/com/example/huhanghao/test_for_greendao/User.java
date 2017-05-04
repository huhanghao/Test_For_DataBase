package com.example.huhanghao.test_for_greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by huhanghao on 2017/4/23.
 */

@Entity
public class User {
    @Id
    private Long id;//@Id必须为Long

    @Unique
    private String identity;//身份唯一

    @Property(nameInDb = "NAME")
    private String name;//改变列名

    @NotNull
    private int age;//不能为空

    @Transient
    private String hobby;//不存储到数据库

    @Generated(hash = 1422233849)
    public User(Long id, String identity, String name, int age) {
        this.id = id;
        this.identity = identity;
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
