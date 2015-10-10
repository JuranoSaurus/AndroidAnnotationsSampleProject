package com.juranoaa.sqlite;

/**
 * Created by SungGeun on 2015-10-10.
 */
public class Constant {

    public static final class SQLite {
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
