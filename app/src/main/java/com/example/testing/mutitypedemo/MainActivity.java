package com.example.testing.mutitypedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnGeneralway;//一般方式处理RecyclerView
    private Button mBtnMutitypeway;//MutiType处理RecyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        dealEvent();
    }

    private void initViews() {
        mBtnGeneralway = (Button) findViewById(R.id.btn_generalway);
        mBtnMutitypeway = (Button) findViewById(R.id.btn_mutitypeway);
    }
    private void dealEvent(){
        mBtnGeneralway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GeneralWayActivity.class));
            }
        });
        mBtnMutitypeway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MutiTypeActivity.class));
            }
        });
    }
}
