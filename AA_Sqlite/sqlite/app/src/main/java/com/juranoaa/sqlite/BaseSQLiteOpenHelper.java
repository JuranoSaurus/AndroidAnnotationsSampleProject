package com.juranoaa.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseSQLiteOpenHelper extends SQLiteOpenHelper{

    public BaseSQLiteOpenHelper(Context context) {
        super(context, Constant.SQLite.DB_NAME, null, Constant.SQLite.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constant.SQLite.BOARD_CREATE);
        db.execSQL(Constant.SQLite.USER_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Constant.SQLite.BOARD_DROP);
        db.execSQL(Constant.SQLite.USER_DROP);
        onCreate(db);
    }

}
