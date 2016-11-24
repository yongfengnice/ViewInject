package com.viewinject;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.viewinject.annatation.ViewId;

public class MainActivity extends BaseActivity {

    @ViewId(R.id.hello)
    private TextView mHello;
    @ViewId(R.id.world)
    private TextView mWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        mHello.setText("Activity里面使用：hello");
        mWorld.setText("Activity里面使用：world");

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, new MainFragment());
        ft.commit();
    }

    @Override
    protected void initTitle() {
        mTitle.setText("这是标题");
    }
}
