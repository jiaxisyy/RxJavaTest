package com.example.shuangxiang.rxjavatest.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shuang.xiang on 2016/7/14.
 */
public class MyOpenHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES ="" ;
    private static String dbName = "Test.db";
    private static int dbVersion = 1;

    public MyOpenHelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
