package com.example.huhanghao.test_for_greendao.realm;

import android.content.Context;

import com.example.huhanghao.test_for_greendao.App;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


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


    public void addData() {
        myOtherRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                UserRealm user = realm.createObject(UserRealm.class);
                user.setName("Gavin");
                user.setAge(23);
            }
        });
    }

    public void asyncAddData() {
        myOtherRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                UserRealm user = bgRealm.createObject(UserRealm.class);
                user.setName("John");
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
            }
        });
    }

    public void upDate() {
        UserRealm user = myOtherRealm.createObject(UserRealm.class);
        user.setName("Gain");
        user.setAge(23);

        Dog dog1 = myOtherRealm.createObject(Dog.class);
        dog1.setAge(1);
        dog1.setName("二哈");
        user.getDogs().add(dog1);

        Dog dog2 = myOtherRealm.createObject(Dog.class);
        dog2.setAge(2);
        dog2.setName("阿拉撕家");
        user.getDogs().add(dog2);
    }

    public void query() {
        RealmQuery<UserRealm> query = myOtherRealm.where(UserRealm.class);

        // Add query conditions:
        query.equalTo("name", "John");
        query.or().equalTo("name", "Peter");

        // Execute the query:
        RealmResults<UserRealm> result1 = query.findAll();

        // Or alternatively do the same all at once (the "Fluent interface"):
        RealmResults<UserRealm> result2 = myOtherRealm.where(UserRealm.class)
                .equalTo("name", "John")
                .or()
                .equalTo("name", "Peter")
                .findAll();
    }


}
