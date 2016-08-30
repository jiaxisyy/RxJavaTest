package com.example.shuangxiang.rxjavatest;

import android.animation.Animator;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.shuangxiang.rxjavatest.utils.CustomToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by shuang.xiang on 2016/7/15.
 */
public class ChangeActivity extends Activity {
    private static final int NOTIFICATION_FLAG = 1;
    private static final String TAG = "ChangeActivity";
    @BindView(R.id.btn_transparency_activity)
    Button btnTransparencyActivity;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.iv_change)
    ImageView ivChange;
    @BindView(R.id.ll_change_activity)
    LinearLayout llChangeActivity;
    @BindView(R.id.vp_change)
    ViewPager vpChange;
    private Animator mAnimator;
    private int mShortAnimationDuration;
    private int integer;
    @BindView(R.id.iv_change_transparency)
    ImageView iv_change_transparency;


    @OnClick(R.id.btn_transparency_activity)
    void transparency() {
        //不可见到可见的渐变
        iv_change_transparency.setAlpha(0f);
        iv_change_transparency.setVisibility(View.VISIBLE);
        iv_change_transparency.animate().alpha(1f).setDuration(2000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_activity);
        ButterKnife.bind(this);
        integer = getResources().getInteger(android.R.integer.config_shortAnimTime);

    }


    public void notificationMethod(View view) {
        // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        switch (view.getId()) {
            // 默认通知
            case R.id.btn1:
                CustomToast.showToast(this, "没写这个方法", Toast.LENGTH_SHORT);
                break;
            // 默认通知 API11及之后可用
            case R.id.btn2:
                PendingIntent pendingIntent2 = PendingIntent.getActivity(this, 0,
                        new Intent(this, MainActivity.class), 0);
                // 通过Notification.Builder来创建通知，注意API Level
                // API11之后才支持
                Notification notify2 = new Notification.Builder(this)
                        .setSmallIcon(R.drawable.message) // 设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示，如果在那里需要更换更大的图片，可以使用setLargeIcon(Bitmap
                        // icon)
                        .setTicker("TickerText:" + "您有新短消息，请注意查收！")// 设置在status
                        // bar上显示的提示文字
                        .setContentTitle("Notification Title")// 设置在下拉status
                        // bar后Activity，本例子中的NotififyMessage的TextView中显示的标题
                        .setContentText("This is the notification message")// TextView中显示的详细内容
                        .setContentIntent(pendingIntent2) // 关联PendingIntent
                        .setNumber(1) // 在TextView的右方显示的数字，可放大图片看，在最右侧。这个number同时也起到一个序列号的左右，如果多个触发多个通知（同一ID），可以指定显示哪一个。
                        .getNotification(); // 需要注意build()是在API level
                // 16及之后增加的，在API11中可以使用getNotificatin()来代替
                notify2.flags |= Notification.FLAG_AUTO_CANCEL;
                manager.notify(NOTIFICATION_FLAG, notify2);
                break;
            // 默认通知 API16及之后可用
            case R.id.btn3:
                PendingIntent pendingIntent3 = PendingIntent.getActivity(this, 0,
                        new Intent(this, MainActivity.class), 0);
                // 通过Notification.Builder来创建通知，注意API Level
                // API16之后才支持
                Notification notify3 = new Notification.Builder(this)
                        .setSmallIcon(R.drawable.message)
                        .setTicker("TickerText:" + "您有新短消息，请注意查收！")
                        .setContentTitle("Notification Title")
                        .setContentText("This is the notification message")
                        .setContentIntent(pendingIntent3).setNumber(1).build(); // 需要注意build()是在API
                // level16及之后增加的，API11可以使用getNotificatin()来替代
                notify3.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
                manager.notify(NOTIFICATION_FLAG, notify3);// 步骤4：通过通知管理器来发起通知。如果id不同，则每click，在status哪里增加一个提示
                break;
            // 自定义通知
            case R.id.btn4:

                /**
                 *
                 * 手打
                 */

                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.my_notification);
                


                break;
            case R.id.btn5:
                // 清除id为NOTIFICATION_FLAG的通知
                manager.cancel(NOTIFICATION_FLAG);
                // 清除所有的通知
                // manager.cancelAll();
                break;
            default:
                break;
        }
    }
}
