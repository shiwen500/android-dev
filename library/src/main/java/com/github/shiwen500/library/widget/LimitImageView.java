package com.github.shiwen500.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.github.shiwen500.library.Measure.MeasureHelper;

/**
 * Created by sunyun004_macmini on 15/12/30.
 * 最小的边不能大于 minLimit
 * 最大得边不能大于 maxLimit
 *
 * 如果最大的边大于 maxLimit 且最小的边大于 minLimit 那么压缩最大边
 */
public class LimitImageView extends ImageView {

    // limit min height or width (dp)
    private int minLimit = 100;

    // limit max height or width (dp)
    private int maxLimit = 200;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LimitImageView(Context context, AttributeSet attrs,
                          int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public LimitImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LimitImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LimitImageView(Context context) {
        super(context);
    }

    public void setMinLimit(int mindp) {
        minLimit = mindp;
    }

    public void setMaxLimit(int maxdp) {
        maxLimit = maxdp;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Bitmap image = ((BitmapDrawable)getDrawable()).getBitmap();

        int width = image.getWidth();
        int height = image.getHeight();


        // 100dp
        int min = MeasureHelper.dp2px(getContext(), minLimit);
        int max = MeasureHelper.dp2px(getContext(), maxLimit);
        if (width > height) {
            // keep scale
            if (height > min) {
                float scale = ((float)min) / height;
                width = (int)(scale * width);
                height = min;
            }

            if (width > max) {
                float scale = ((float)max) /width;
                height = (int)(scale * height);
                width = max;
            }

        } else {
            // keep scale
            if (width > min) {
                float scale = ((float)min) /width;
                height = (int)(scale * height);
                width = min;
            }

            if (height > max) {
                float scale = ((float)max) / height;
                width = (int)(scale * width);
                height = max;
            }
        }

        widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
