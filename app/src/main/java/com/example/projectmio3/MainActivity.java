package com.example.projectmio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectmio3.R;
import com.example.projectmio3.helper.SharedPref;

public class MainActivity extends AppCompatActivity {
    Button mBtnLogout;
    Button mBtnAddUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLogout = findViewById(R.id.bt_logout);
        mBtnAddUser = findViewById(R.id.bt_add_user);

        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getInstance(MainActivity.this).setLogin(false);
                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

        mBtnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getInstance(MainActivity.this).setLogin(false);
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
            }
        });


    }
}
