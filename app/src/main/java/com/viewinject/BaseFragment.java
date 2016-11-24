package com.viewinject;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewinject.utils.ViewInject;


/**
 * Created by yongfeng on 2016/11/25.
 * Email:2499522170@qq.com
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutResID = setLayoutID();
        if (layoutResID < 0) throw new IllegalArgumentException("必须重写setContentView()指定一个布局文件");
        return inflater.inflate(layoutResID, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewInject.recurseInject(this, BaseFragment.class);
        initView();
    }

    public abstract int setLayoutID();

    protected abstract void initView();
}
