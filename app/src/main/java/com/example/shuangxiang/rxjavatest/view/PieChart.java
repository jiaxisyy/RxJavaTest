package com.example.shuangxiang.rxjavatest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.example.shuangxiang.rxjavatest.R;

/**
 * Created by shuang.xiang on 2016/8/5.
 */
public class PieChart extends View {

    private boolean aBoolean;
    private final int integer;

    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.PieChart,
                0, 0);

        try {

            aBoolean = a.getBoolean(R.styleable.PieChart_mShowText, false);
            integer = a.getInteger(R.styleable.PieChart_labelPosition, 0);
        } finally {
            a.recycle();
        }
    }
    public boolean isShowText() {
        return aBoolean;
    }

    public void setShowText(boolean is) {
        aBoolean = is;
        invalidate();
        requestLayout();
    }
}
