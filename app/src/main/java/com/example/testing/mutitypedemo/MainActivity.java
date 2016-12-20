package com.example.testing.mutitypedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnGeneralway;//一般方式处理RecyclerView
    private Button mBtnMultitype1way;//MultiType方式处理RecyclerView（嵌套Item）
    private Button mBtnMultitype2way;//MultiType方式处理RecyclerView（顺序添加）
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        dealEvent();
    }

    private void initViews() {
        mBtnGeneralway = (Button) findViewById(R.id.btn_generalway);
        mBtnMultitype1way = (Button) findViewById(R.id.btn_multitype1way);
        mBtnMultitype2way = (Button) findViewById(R.id.btn_multitype2way);
    }
    private void dealEvent(){
        mBtnGeneralway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GeneralWayActivity.class));
            }
        });
        mBtnMultitype1way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MultiType1Activity.class));
            }
        });
        mBtnMultitype2way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MultiType2Activity.class));
            }
        });
    }
}
