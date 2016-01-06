package com.github.shiwen500.library.Utils;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by sunyun004_macmini on 16/1/6.
 */
public class InjectParse {

    public static void injectFields(Activity activity, View.OnClickListener onClickListener) throws IllegalAccessException {

        Class clazz = activity.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields) {
            if (field.isAnnotationPresent(InjectView.class)) {
                InjectView inject = field.getAnnotation(InjectView.class);
                int id = inject.id();
                boolean clickable = inject.clickable();

                if (id > 0) {
                    View target = activity.findViewById(id);

                    field.setAccessible(true);
                    field.set(activity, target);

                    if (onClickListener != null && target != null && clickable) {
                        target.setOnClickListener(onClickListener);
                    }
                }
            }
        }
    }
}
