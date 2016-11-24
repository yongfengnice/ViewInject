package com.viewinject;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viewinject.annatation.ViewId;
import com.viewinject.utils.ViewInject;

/**
 * Created by yongfeng on 2016/11/25.
 * Email:2499522170@qq.com
 */
public abstract class BaseActivity extends FragmentActivity {

    @ViewId(R.id.base_title)
    protected TextView mTitle;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_base);
        View.inflate(this, layoutResID, (ViewGroup) findViewById(R.id.ll_root));
        ViewInject.recurseInject(this, BaseActivity.class);
        initTitle();
    }

    protected abstract void initTitle();
}
