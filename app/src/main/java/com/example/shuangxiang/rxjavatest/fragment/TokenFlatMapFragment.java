package com.example.shuangxiang.rxjavatest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shuangxiang.rxjavatest.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by shuang.xiang on 2016/7/12.
 */
public class TokenFlatMapFragment extends Fragment {
    private static final String TAG = "TokenFlatMapFragment";
    protected Subscription sub;

    @BindView(R.id.tv_flat)
    TextView textView;
    @BindView(R.id.btn_flatMap)
    Button button;

    @OnClick(R.id.btn_flatMap)
    void flatMap() {
        Log.d(TAG, "flatMap");
        unsubscribe();
        sub = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello1");
                subscriber.onNext("hello2");
                subscriber.onNext("hello3");
                subscriber.onNext("hello4");
                subscriber.onNext("hello5");
                subscriber.onNext("hello6");
            }
        }).take(5).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, s);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, throwable.toString());
            }
        });

        Observable.just(getString()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer s) {
                Log.d(TAG, s+"");

            }
        });

    }


    private int getString() {
        return 2;
    }

    private void unsubscribe() {
        if (sub != null && !sub.isUnsubscribed()) {
            sub.unsubscribe();
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flat_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
