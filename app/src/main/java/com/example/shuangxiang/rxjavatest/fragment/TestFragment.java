package com.example.shuangxiang.rxjavatest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.shuangxiang.rxjavatest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shuang.xiang on 2016/7/12.
 */
public class TestFragment extends Fragment {
    private static final String TAG = "TestFragment";
    @BindView(R.id.sb_test)
    SeekBar sbTest;
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.btn_test_pay)
    Button btnTestPay;
    private String cache = null;
    @BindView(R.id.btn_test1)
    Button btnTest1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sbTest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvTest.setText("Value:" + progress);
                seekBar.setSecondaryProgress((progress + seekBar.getMax()) / 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    @OnClick(R.id.btn_test_pay)
    public void onClick() {

    }

}
