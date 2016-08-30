package com.example.shuangxiang.rxjavatest.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shuangxiang.rxjavatest.R;
import com.example.shuangxiang.rxjavatest.utils.Utils;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by shuang.xiang on 2016/7/12.
 */
public class BroadcastFragment extends Fragment {

    private static final String TAG = "BroadcastFragment";
    @BindView(R.id.btn_broadcast_register)
    Button btnBroadcastRegister;
    @BindView(R.id.btn_broadcast_cancel)
    Button btnBroadcastCancel;
    @BindView(R.id.btn_broadcast_send)
    Button btnBroadcastSend;
    @BindView(R.id.et_broadcast)
    EditText etBroadcast;
    @BindView(R.id.tv_broadcast)
    TextView tv_broadcast;
    private ReceiveBroadCast receiveBroadCast;
    private static String FLAG = "1";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.broadcast_receiver_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.btn_broadcast_register, R.id.btn_broadcast_cancel, R.id.btn_broadcast_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_broadcast_register:
                // 注册广播接收
                boolean validClick = Utils.isValidClick();
                if (validClick) {
                    receiveBroadCast = new ReceiveBroadCast();
                    IntentFilter filter = new IntentFilter();
                    filter.addAction(FLAG);    //只有持有相同的action的接受者才能接收此广播
                    getActivity().registerReceiver(receiveBroadCast, filter);
                }

                break;
            case R.id.btn_broadcast_cancel:


                getActivity().unregisterReceiver(receiveBroadCast);


                break;
            case R.id.btn_broadcast_send:
                Intent intent = new Intent();  //Itent就是我们要发送的内容
                intent.putExtra("data", "this is data from broadcast " + Calendar.getInstance().get(Calendar.SECOND));
                intent.setAction(FLAG);   //设置你这个广播的action，只有和这个action一样的接受者才能接受者才能接收广播
                getActivity().sendBroadcast(intent);   //发送广播
                break;
        }
    }

    public class ReceiveBroadCast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //得到广播中得到的数据，并显示出来
            String message = intent.getStringExtra("data");
            tv_broadcast.setText(message);
        }

    }
}

