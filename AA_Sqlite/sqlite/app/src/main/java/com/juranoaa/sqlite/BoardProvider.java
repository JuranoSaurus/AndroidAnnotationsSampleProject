package com.juranoaa.sqlite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

/**
 * Created by SungGeun on 2015-10-10.
 */
public class BoardProvider extends ContentProvider {
    private static final String TAG = BoardProvider.class.getSimpleName();

    public static final String TABLE_NAME_BOARD = "dbBoard";
    private static final String AUTHORITY = "com.juranoaa.sqlite";

    public static final Uri CONTENT_URI_BOARD = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME_BOARD);

    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";

    /** create db string */
    public static final String DATABASE_CREATE_BOARD =
            "CREATE TABLE " + TABLE_NAME_BOARD +
            " (" + COL_ID + " INTEGER PRIMARY KEY,"
            + COL_TITLE + " TEXT );";

    private static BoardDataBaseHelper mDbHelperBoard;
    private SQLiteDatabase mDbBoard;

    @Override
    public boolean onCreate() {
        mDbHelperBoard = new BoardDataBaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        mDbBoard = mDbHelperBoard.getReadableDatabase();
        Cursor cursor = mDbBoard.query(TABLE_NAME_BOARD, projection, selection,
                selectionArgs, null, null, sortOrder);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        mDbBoard = mDbHelperBoard.getWritableDatabase();
        mDbBoard.insertOrThrow(TABLE_NAME_BOARD, null, values);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        mDbBoard = mDbHelperBoard.getWritableDatabase();
        int count = mDbBoard.delete(TABLE_NAME_BOARD, selection, selectionArgs);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        mDbBoard = mDbHelperBoard.getWritableDatabase();
        int count = mDbBoard.update(TABLE_NAME_BOARD, values, selection, selectionArgs);
        return count;
    }

    private static class BoardDataBaseHelper extends SQLiteOpenHelper {

        private static final String TAG = BoardDataBaseHelper.class.getSimpleName();

        public BoardDataBaseHelper(Context context){
            super(context, Constant.SQLite.DB_NAME, null, Constant.SQLite.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_BOARD);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "invoked! " + oldVersion + " -> " + newVersion + ", it'll destroy old data");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_BOARD);
            onCreate(db);

        }
    }
}
