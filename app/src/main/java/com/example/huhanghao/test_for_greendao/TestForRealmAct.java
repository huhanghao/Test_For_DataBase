package com.example.huhanghao.test_for_greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.huhanghao.test_for_greendao.realm.Country;
import com.example.huhanghao.test_for_greendao.realm.RealmUtils;

import io.realm.Realm;
import io.realm.RealmResults;

public class TestForRealmAct extends AppCompatActivity {

    private Realm myRealm = RealmUtils.getInstance().realmInit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_for_reaml);


        View btn1 = findViewById(R.id.tv_btn_add);
        View btn2 = findViewById(R.id.tv_btn_del);
        View btn3 = findViewById(R.id.tv_btn_update);
        View btn4 = findViewById(R.id.tv_btn_search);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRealm.beginTransaction();
                // Create an object
                Country country1 = myRealm.createObject(Country.class);
                // Set its fields
                country1.setName("Norway");
                country1.setPopulation(5165800);
                country1.setCode("NO");
                myRealm.commitTransaction();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the object
                Country country2 = new Country();
                country2.setName("Russia");
                country2.setPopulation(146430430);
                country2.setCode("RU");

                myRealm.beginTransaction();
                Country copyOfCountry2 = myRealm.copyToRealm(country2);
                myRealm.commitTransaction();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealmResults<Country> results1 =
                        myRealm.where(Country.class).findAll();

                for(Country c:results1) {
                    Log.d("results1", c.getName());
                }

            }
        });
    }
}
