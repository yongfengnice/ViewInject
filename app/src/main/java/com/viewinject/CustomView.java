package com.viewinject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viewinject.annatation.ViewId;
import com.viewinject.utils.ViewInject;

/**
 * Created by yongfeng on 2016/11/13.
 */
public class CustomView extends LinearLayout {
    @ViewId(R.id.custom1)
    TextView mCustom1;
    @ViewId(R.id.custom2)
    TextView mCustom2;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_main, this);
        ViewInject.inject(this);
        initData();
    }

    private void initData() {
        mCustom1.setText("自定义View里面使用：mCustom1");
        mCustom2.setText("自定义View里面使用：mCustom2");
    }
}
