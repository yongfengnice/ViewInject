package com.viewinject.utils;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

import com.viewinject.annatation.ViewId;

import java.lang.reflect.Field;

/**
 * Created by yongfeng on 2016/11/12.
 */
public class ViewInject {

    /**
     * 实例化Activity里面的View成员变量
     *
     * @param activity
     */
    public static void inject(Activity activity) {
        if (activity == null) return;
        Field[] fields = activity.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(ViewId.class)) continue;
            ViewId resId = field.getAnnotation(ViewId.class);
            if (resId != null) {
                if (!field.isAccessible()) field.setAccessible(true);
                try {
                    field.set(activity, activity.findViewById(resId.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 实例化Fragment里面的View成员变量
     *
     * @param fragment
     */
    public static void inject(Fragment fragment) {
        if (fragment == null) return;
        View view = fragment.getView();
        if (view == null)
            throw new NullPointerException("the fragment's view is null, please call after onActivityCreated() method");
        Field[] fields = fragment.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(ViewId.class)) continue;
            ViewId resId = field.getAnnotation(ViewId.class);
            if (resId != null) {
                if (!field.isAccessible()) field.setAccessible(true);
                try {
                    field.set(fragment, view.findViewById(resId.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 实例化一个自定义View里面的View成员变量
     *
     * @param view
     */
    public static void inject(View view) {
        if (view == null) return;
        Field[] fields = view.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(ViewId.class)) continue;
            ViewId resId = field.getAnnotation(ViewId.class);
            if (resId != null) {
                if (!field.isAccessible()) field.setAccessible(true);
                try {
                    field.set(view, view.findViewById(resId.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
