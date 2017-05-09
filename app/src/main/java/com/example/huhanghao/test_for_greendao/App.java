package com.example.huhanghao.test_for_greendao;

import android.app.Application;
import android.widget.Toast;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

/**
 * Created by root on 8/22/16.
 */
public class App extends Application {
    /**
     * 222.
     */
    private static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        // FreelineCore.init(this);

        INSTANCE = this;
        initRealm();
    }

    public static App getInstance() {
        return INSTANCE;
    }

    /**
     * .
     */
    private Toast mToast;

    /**
     * 1.
     *
     * @param s 信息数据
     */
    public void showMessage(String s) {
        if (mToast == null) {
            mToast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        }
        mToast.setText(s);
        mToast.show();
    }

    /**
     * 展示数据.
     *
     * @param res 数据。
     */
    public void showMessage(int res) {
        if (mToast == null) {
            mToast = new Toast(this);
        }
        mToast.setText(res);
        mToast.show();
    }

    /**
     * 初始化real.
     */
    private void initRealm(){
        RealmConfiguration configuration = new RealmConfiguration
                .Builder(this)
                .name(RealmUtils.DB_NAME)
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(7).migration(new RealmMigration() {

                    @Override
                    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

                    }
                }).build();

        Realm.setDefaultConfiguration(configuration);
    }

}
