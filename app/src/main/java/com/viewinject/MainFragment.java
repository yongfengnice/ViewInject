package com.viewinject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viewinject.annatation.ViewId;
import com.viewinject.utils.ViewInject;

/**
 * Created by yongfeng on 2016/11/13.
 */
public class MainFragment extends Fragment {
    @ViewId(R.id.test)
    private TextView mTest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewInject.inject(this);
        mTest.setText("这部分是Fragment，在Fragment里面使用");
    }
}
