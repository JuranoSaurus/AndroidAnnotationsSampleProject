package com.juranoaa.sqlite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by SungGeun on 2015-10-10.
 */
public class BaseContentProvider extends ContentProvider{

    private BaseSQLiteOpenHelper baseSQLiteOpenHelper;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(Constant.SQLite.AUTHORITY, Constant.SQLite.TABLE_BOARD_NAME, Constant.SQLite.BOARD);
        uriMatcher.addURI(Constant.SQLite.AUTHORITY, Constant.SQLite.TABLE_USER_NAME, Constant.SQLite.USER);
    }

    private boolean isMatch(Uri uri){
        Integer match = uriMatcher.match(uri);
        return !(match.equals(Constant.SQLite.BOARD)|| match.equals(Constant.SQLite.USER));
    }

    @Override
    public boolean onCreate() {
        baseSQLiteOpenHelper = new BaseSQLiteOpenHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if(isMatch(uri)){
            throw new UnsupportedOperationException();
        }else{

        }
        SQLiteDatabase db = baseSQLiteOpenHelper.getReadableDatabase();
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        if(isMatch(uri)){
            throw new UnsupportedOperationException();
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if(isMatch(uri)){
            throw new UnsupportedOperationException();
        }
        SQLiteDatabase db = baseSQLiteOpenHelper.getWritableDatabase();
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if(isMatch(uri)){
            throw new UnsupportedOperationException();
        }
        SQLiteDatabase db = baseSQLiteOpenHelper.getWritableDatabase();
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if(isMatch(uri)){
            throw new UnsupportedOperationException();
        }
        SQLiteDatabase db = baseSQLiteOpenHelper.getWritableDatabase();
        return 0;
    }
}
