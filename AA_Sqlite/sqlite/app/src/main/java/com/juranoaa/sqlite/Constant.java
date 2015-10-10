package com.juranoaa.sqlite;

import android.content.ContentResolver;
import android.net.Uri;

/**
 * Created by SungGeun on 2015-10-10.
 */
public class Constant {

    public static final class SQLite {
        public static final Integer DB_VERSION = 1;
        public static final String DB_NAME = "AATest.db";

        public static final Integer USER = 1;
        public static final Integer BOARD = 2;

        public static final String AUTHORITY = "com.juranoaa.sqlite.contentprovide";
        public static final String TABLE_BOARD_NAME = "board";
        public static final String TABLE_USER_NAME = "user";

        public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/"+TABLE_BOARD_NAME);

        public static final String BOARD_CREATE =  "CREATE TABLE " + TABLE_BOARD_NAME + " ("+
                                                    " _id INTEGER PRIMARY KEY AUTOINCREMENT "+
                                                    " title VARCHAR NOT NULL"+
                                                    " content VARCHAR NOT NULL"+
                                                    ")";
        public static final String BOARD_DROP =     "DROP TABLE IF EXIST " + TABLE_BOARD_NAME ;
        public static final String USER_CREATE =    "CREATE TABLE " + TABLE_USER_NAME + " ("+
                                                    " _id INTEGER PRIMARY KEY AUTOINCREMENT "+
                                                    " name VARCHAR NOT NULL"+
                                                    ")";
        public static final String USER_DROP =      "DROP TABLE IF EXIST " + TABLE_USER_NAME ;
    }
}
