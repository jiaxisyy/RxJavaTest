package com.example.shuangxiang.rxjavatest;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by shuang.xiang on 2016/7/19.
 */
public class ZoomOutTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View view, float position) {
        int viewWidth = view.getWidth();
        int viewHeight = view.getHeight();
        if (position < -1) {
            view.setAlpha(0);

        } else if (position <= 1) {
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = viewHeight * (1 - scaleFactor) / 2;
            float horzMargin = viewWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin-vertMargin/2);

            }else {

                view.setTranslationX(-horzMargin+vertMargin/2);
            }
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setAlpha(MIN_ALPHA+(scaleFactor-MIN_SCALE)/(1-MIN_SCALE)*(1-MIN_ALPHA));

        }else {

            view.setAlpha(0);
        }
    }
}
