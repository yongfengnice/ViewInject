package com.viewinject;

import android.widget.TextView;

import com.viewinject.annatation.ViewId;

/**
 * Created by yongfeng on 2016/11/13.
 */
public class MainFragment extends BaseFragment {
    @ViewId(R.id.test)
    private TextView mTest;

    @Override
    public int setLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        mTest.setText("这部分是Fragment，在Fragment里面使用");
    }
}
