package com.github.shiwen500.library.View;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;

/**
 * Created by Seven on 2015/12/29.
 */
public class ViewHelper {

    public int getActionBarHeight(Context context) {
        int actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,
                    context.getResources().getDisplayMetrics());
        }
        return actionBarHeight;
    }

    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private View getActionBarView(Activity context) {
        Window window = context.getWindow();
        View v = window.getDecorView();
        int resId = context.getResources().getIdentifier("action_bar_container", "id",
                context.getPackageName());
        if (resId == 0) {
            resId = context.getResources().getIdentifier("action_bar_container", "id",
                    "android");
        }
        return v.findViewById(resId);
    }
}
