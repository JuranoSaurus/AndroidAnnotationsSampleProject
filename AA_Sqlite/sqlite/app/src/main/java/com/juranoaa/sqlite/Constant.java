package com.juranoaa.sqlite;

import android.content.ContentResolver;
import android.net.Uri;

/**
 * Created by SungGeun on 2015-10-10.
 */
public class Constant {

    public static final class SQLite {
        public static final int TESTS = 10;
        public static final int TEST_ID = 20;
        public static final String AUTHORITY = "com.juranoaa.sqlite.contentprovide";
        public static final String BASE_PATH = "tests";
        public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/"+BASE_PATH);
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE+"/tests";
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE+"/test";

        public static final Integer DB_VERSION = 1;
        public static final String DB_NAME = "AATest.db";

        public static final String TABLE_NAME = "board";
        public static final String DB_CREATE =  "CREATE TABLE " + TABLE_NAME + " ("+
                                                " id INTEGER PRIMARY KEY AUTOINCREMENT "+
                                                " title VARCHAR NOT NULL"+
                                                " content VARCHAR NOT NULL"+
                                                ")";
        public static final String DB_DROP =    "DROP TABLE IF EXIST " + TABLE_NAME ;
    }
}
