package com.example.huhanghao.test_for_greendao;

import android.content.Context;
import com.inst.greendao3_demo.dao.DaoMaster;
import com.inst.greendao3_demo.dao.DaoSession;
import com.inst.greendao3_demo.dao.UserDao;

import static org.greenrobot.greendao.test.DbTest.DB_NAME;


/**
 * Created by huhanghao on 2017/5/4.
 */

public class DaoUtils {

    private static DaoUtils mDaoUtils;
    private static final Object SYNC_LOCK = new Object();
    public static Context context = App.getInstance();
    private UserDao userDao;

    public static DaoUtils getInstance() {

        if (mDaoUtils == null) {
            synchronized (SYNC_LOCK) {
                if (mDaoUtils == null) {
                    mDaoUtils = new DaoUtils();
                }
            }
        }
        return mDaoUtils;
    }


    /**
     * 返回表对象.
     *
     * @param dataBaseName 这个
     * @return 返回
     */
    public UserDao openDateBase(String dataBaseName) {
        if (userDao == null) {
            //创建dbmanager类初始化数据库
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            DaoSession daoSession = daoMaster.newSession();
            userDao = daoSession.getUserDao();
        }
        return userDao;
    }


}
