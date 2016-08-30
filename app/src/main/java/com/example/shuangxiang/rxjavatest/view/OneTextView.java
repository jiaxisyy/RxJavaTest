package com.example.shuangxiang.rxjavatest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by shuang.xiang on 2016/8/6.
 */
public class OneTextView extends TextView {

    private final Paint paint;

    public OneTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //这部分是在原生控件绘制之前进行绘制的，位于原生控件绘制区域底层，不会遮挡其他内容
        //第一个矩形，大小跟此控件一样大，位于底层
        paint.setColor(Color.BLUE);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);

        //第二个矩形，稍微小一点，但是会遮挡第一个矩形
        paint.setColor(Color.RED);
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,paint);
        //原生控件开始绘制，会遮挡上面代码绘制的内容。
        super.onDraw(canvas);
        //第三个矩形，这是在原生控件绘制完毕后进行绘制的，位于原生控制的上层，会遮挡所有之前绘制的内容
        paint.setColor(Color.GREEN);
        canvas.drawRect(20, 20,100, 50, paint);
    }
}
