package com.example.shuangxiang.rxjavatest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.shuangxiang.rxjavatest.R;

/**
 * Created by shuang.xiang on 2016/8/6.
 */
public class CustomTitleView extends View {
    //文本
    private String mTitleText;
    //文本的颜色

    private int mTitleTextColor;
    //文本的大小
    private int mTitleTextSize;
    //绘制时控制文本绘制的范围
    private Rect mBound;
    private Paint mPaint;

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleView(Context context) {
        this(context, null);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获取我们自定义的自定义样式属性
         *
         */
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int indexCount = array.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int attr = array.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitleView_mTitleText:
                    mTitleText = array.getString(attr);
                    break;
                case R.styleable.CustomTitleView_mTitleTextColor:
                    //默认颜色设置为黑色
                    array.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_mTitleTextSize:
                    //默认设置为16sp,TypeValue也可以把sp转化为px
                    mTitleTextSize = array.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));

                    break;

            }

        }
        array.recycle();
        /**
         *
         * 绘制文本的高和宽
         *
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);

    }
}