package com.example.huhanghao.test_for_greendao;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by huhanghao on 2017/5/9.
 */

public class Country extends RealmObject {
    private String name;
    private int population;

    public Country() { }

    @PrimaryKey
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
