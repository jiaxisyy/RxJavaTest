package com.example.shuangxiang.rxjavatest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.shuangxiang.rxjavatest.fragment.TestFragment;
import com.example.shuangxiang.rxjavatest.fragment.ElementaryFragment;
import com.example.shuangxiang.rxjavatest.fragment.MapFragment;
import com.example.shuangxiang.rxjavatest.fragment.TokenFlatMapFragment;
import com.example.shuangxiang.rxjavatest.fragment.TokenRetryWhenFragment;
import com.example.shuangxiang.rxjavatest.fragment.BroadcastFragment;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    private Toolbar tb_main;
    private TabLayout tl_main;
    private ViewPager vp_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // test1();
//       test2();
        final String[] titles = {"基本", "转换(map)", "Broadcast", "TOKEN(FLATMAP)", "TOKEN高级(retryWhen)", "测试", "Change"};
        initialize();
        setSupportActionBar(tb_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vp_main.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new ElementaryFragment();
                    case 1:
                        return new MapFragment();
                    case 2:
                        return new BroadcastFragment();
                    case 3:
                        return new TokenFlatMapFragment();
                    case 4:
                        return new TokenRetryWhenFragment();
                    case 5:
                        return new TestFragment();
                    case 6:
                        return new ChangeFragment();
                    default:
                        return new ElementaryFragment();


                }
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        vp_main.setPageTransformer(true, new ZoomOutTransformer());
        tl_main.setSelectedTabIndicatorColor(Color.RED);
        tl_main.setTabTextColors(Color.BLACK, Color.WHITE);
        tl_main.setupWithViewPager(vp_main);
        tl_main.setBackgroundColor(Color.BLUE);


    }


    /**
     * 使用okhttp网络请求
     */
    private void test3() {
        String loginUrl = "http://kawakp.chinclouds.com:58010/userconsle/login";
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {


            }
        });


    }

    /**
     * flatMap
     */
    private void test2() {
        Student student1 = new Student("1", "math", 10);
        Student student2 = new Student("2", "chinese", 10);
        Student student3 = new Student("3", "english", 10);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Student[] objects = {student1, student2, student3};


        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

                Log.d("TAG", s);

            }
        };
        Observable<String> observable = Observable.from(objects).flatMap(new Func1<Student, Observable<String>>() {
            @Override
            public Observable<String> call(Student student) {
                return Observable.from(new String[]{student.getCourses()});
            }
        });
        observable.subscribe(subscriber);


    }

    private void initialize() {

        tb_main = (Toolbar) findViewById(R.id.tb_main);
        tl_main = (TabLayout) findViewById(R.id.tl_main);
        vp_main = (ViewPager) findViewById(R.id.vp_main);
    }


    /**
     * subscribeOn
     */
   /* private void test1() {

        final int drawableId = R.mipmap.ic_launcher;
        final ImageView imageView = (ImageView) findViewById(R.id.iv_show);
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getResources().getDrawable(drawableId);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Drawable>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        imageView.setImageDrawable(drawable);

                    }
                });
    }*/
}
