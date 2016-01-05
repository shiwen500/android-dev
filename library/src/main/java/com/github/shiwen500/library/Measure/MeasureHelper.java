package com.github.shiwen500.library.Measure;

import android.content.Context;

/**
 * Created by sunyun004_macmini on 15/12/30.
 */
public class MeasureHelper {

    public static int dp2px(Context context, int dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
