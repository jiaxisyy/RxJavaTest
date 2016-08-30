package com.example.shuangxiang.rxjavatest.fragment;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shuangxiang.rxjavatest.ImageViewModel;
import com.example.shuangxiang.rxjavatest.MyAdapter;
import com.example.shuangxiang.rxjavatest.R;
import com.example.shuangxiang.rxjavatest.utils.CacheUtils;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by shuang.xiang on 2016/7/12.
 */
public class ElementaryFragment extends Fragment {
    private static final String TAG = "ElementaryFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.elementary_fragment, container, false);
        Button btn_ele = (Button) inflate.findViewById(R.id.btn_ele);
        Button btn_download = (Button) inflate.findViewById(R.id.btn_download);
        final TextView tv_login = (TextView) inflate.findViewById(R.id.tv_login);
        final OkHttpClient okHttpClient = new OkHttpClient();

        RecyclerView rv_ele = (RecyclerView) inflate.findViewById(R.id.rv_ele);
        rv_ele.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        ImageViewModel image1 = new ImageViewModel("装逼被雷劈", "http://zhuangbi.idagou.com/i/2016-07-11-56c03b5b59212a016bb4daa57272b365.jpg");
        ImageViewModel image2 = new ImageViewModel("装逼喷血", "http://zhuangbi.idagou.com/i/2016-07-08-dbb7d1f77df13c0292e5b286e72cd005.gif");
        final List<ImageViewModel> list = new ArrayList<>();
        list.add(image1);
        list.add(image2);
        final MyAdapter myAdapter = new MyAdapter(list, getActivity());
        rv_ele.setAdapter(myAdapter);
        //下载带cookie
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String downloadUrl = "http://kawakp.chinclouds.com:58010/userconsle/clientApps/techray-coic/file";
                final String cookie = CacheUtils.getString(getActivity(), "cookie");
                if (!TextUtils.isEmpty(cookie)) {

                    Observable.create(new Observable.OnSubscribe<String>() {
                        @Override
                        public void call(final Subscriber<? super String> subscriber) {
                            Request request = new Request.Builder().addHeader("cookie", cookie).url(downloadUrl).get().build();
                            okHttpClient.newCall(request).enqueue(new Callback() {
                                @Override
                                public void onFailure(Request request, IOException e) {
                                    Log.e(TAG, e.toString());

                                }

                                @Override
                                public void onResponse(Response response) throws IOException {
                                    InputStream in = response.body().byteStream();
                                    byte[] bytes = new byte[1024 * 8];
                                    int len = 0;
                                    File file = new File(Environment.getExternalStorageDirectory() + "/Download/techray-coic.apk");
                                    FileOutputStream out = new FileOutputStream(file);
                                    while ((len = in.read(bytes)) != -1) {
                                        out.write(bytes, 0, len);
                                    }
                                    out.flush();
                                    in.close();
                                    out.close();
                                    subscriber.onNext("完成");
                                }
                            });

                        }
                    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(String s) {
                            tv_login.setText(s);

                        }
                    });


                }


            }
        });


        //网络表单请求
        btn_ele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rxJava
                //仿登录,使用http
                final String loginUrl = "http://kawakp.chinclouds.com:58010/userconsle/login";
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {


                        RequestBody build = new FormEncodingBuilder().add("username", "sanji").add("password", "111111").build();
                        Request request = new Request.Builder().url(loginUrl).post(build).build();
                        try {
                            Response response = okHttpClient.newCall(request).execute();
                            String header = response.header("set-cookie");
                            String cookie = header.substring(0, header.indexOf(";"));
                            CacheUtils.putString(getActivity(), "cookie", cookie);

                            Log.d(TAG, "header=" + header);
                            Log.d(TAG, "cookie=" + cookie);
                            subscriber.onNext(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).subscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.toString());

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, s);
                        tv_login.setText(s);
                    }
                });


            }
        });
        return inflate;
    }

}
