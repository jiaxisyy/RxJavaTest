package com.example.shuangxiang.rxjavatest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shuangxiang.rxjavatest.ImageViewModel;
import com.example.shuangxiang.rxjavatest.MyAdapter;
import com.example.shuangxiang.rxjavatest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by shuang.xiang on 2016/7/12.
 */
public class MapFragment extends Fragment {

    //   private Button map;
    @BindView(R.id.btn_map)
    Button map;
    @BindView(R.id.rv_map)
    RecyclerView recyclerView;

    Observer<List<ImageViewModel>> observer = new Observer<List<ImageViewModel>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(List<ImageViewModel> imageViewModels) {

        }
    };
    private MyAdapter adapter;

    @OnClick(R.id.btn_map)
    void map() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
            }
        });


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_fragment, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        List<ImageViewModel> imageViewModels = new ArrayList<>();
        ImageViewModel model1 = new ImageViewModel("别让我走", "http://zhuangbi.idagou.com/i/2015-10-24-99a9eda4ca614dbdb63d2b9623afaf9b.jpg");
        ImageViewModel model2 = new ImageViewModel("我要装逼", "http://zhuangbi.idagou.com/i/2015-11-12-5bf96a057261d25958a2d818b49eaf85.jpg");
        imageViewModels.add(model1);
        imageViewModels.add(model2);

        adapter = new MyAdapter(imageViewModels, getActivity());

        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}
