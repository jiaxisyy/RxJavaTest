package com.example.shuangxiang.rxjavatest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shuangxiang.rxjavatest.sql.MyOpenHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shuang.xiang on 2016/7/14.
 */
public class ChangeFragment extends Fragment {
    @BindView(R.id.btn_change)
    Button btnChange;
    @BindView(R.id.btn_change_toAdaptive)
    Button btnChangeToAdaptive;

    @OnClick(R.id.btn_change)
    void change() {
        startActivity(new Intent(getActivity(), ChangeActivity.class));
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.change_fragment, container, false);
        MyOpenHelper myOpenHelper = new MyOpenHelper(getActivity());
        ButterKnife.bind(this, view);
        return view;

    }

    @OnClick(R.id.btn_change_toAdaptive)
    public void onClick() {
        startActivity(new Intent(getActivity(), AdaptiveActivity.class));

    }
}
