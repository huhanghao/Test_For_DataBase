package com.example.huhanghao.test_for_greendao;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by root on 8/22/16.
 */
public class APP extends Application {

    private static APP INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
//        FreelineCore.init(this);

        INSTANCE = this;
    }

    public static APP getInstance() {
        return INSTANCE;
    }

    private Toast mToast;

    public void showMessage(String s) {
        if (mToast == null) mToast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        mToast.setText(s);
        mToast.show();
    }

    public void showMessage(int res) {
        if (mToast == null) mToast = new Toast(this);
        mToast.setText(res);
        mToast.show();
    }

}
