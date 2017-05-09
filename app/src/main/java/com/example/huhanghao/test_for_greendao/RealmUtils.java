package com.example.huhanghao.test_for_greendao;

import android.content.Context;

import io.realm.Realm;


/**
 * Created by huhanghao on 2017/5/4.
 */

public class RealmUtils {

    public static final String DB_NAME = "myRealm.realm";

    private static RealmUtils mRealmUtils;
    private static final Object SYNC_LOCK = new Object();
    public static Context context = App.getInstance();
    private Realm myOtherRealm;

    public static RealmUtils getInstance() {

        if (mRealmUtils == null) {
            synchronized (SYNC_LOCK) {
                if (mRealmUtils == null) {
                    mRealmUtils = new RealmUtils();
                }
            }
        }
        return mRealmUtils;
    }


    /**
     * 返回表对象.
     *
     * @return 返回
     */
    public Realm realmInit() {
        if (myOtherRealm == null) {
            myOtherRealm = Realm.getDefaultInstance();
            //创建dbmanager类初始化数据库
        }
        return myOtherRealm;
    }


}
