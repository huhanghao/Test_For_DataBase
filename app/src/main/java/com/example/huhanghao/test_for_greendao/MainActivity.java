package com.example.huhanghao.test_for_greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btn1 = findViewById(R.id.tv_btn_add);
        View btn2 = findViewById(R.id.tv_btn_del);
        View btn3 = findViewById(R.id.tv_btn_update);
        View btn4 = findViewById(R.id.tv_btn_search);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User mUser = new User((long) 2, "123412412412", "yuShu", 18);
                DaoUtils.getInstance().openDateBase("user.db").insert(mUser);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoUtils.getInstance().openDateBase("user.db").deleteByKey((long) 2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User mUser = new User((long) 2, "123412412412", "yuShu", 25);
                DaoUtils.getInstance().openDateBase("user.db").update(mUser);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoUtils.getInstance().openDateBase("user.db").loadAll();  //查询所有
                QueryBuilder<User> qb =  DaoUtils.getInstance().openDateBase("user.db").queryBuilder();
                qb.where(UserDao.Properties.Id.eq(2)).orderAsc(UserDao.Properties.Age);
                List<User> list = qb.list();
            }
        });
    }
}
