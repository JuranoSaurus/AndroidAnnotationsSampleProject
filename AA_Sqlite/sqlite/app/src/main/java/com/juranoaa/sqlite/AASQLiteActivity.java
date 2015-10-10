package com.juranoaa.sqlite;

import android.app.Activity;
import android.content.Context;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EActivity;

/**
 * Created by SungGeun on 2015-10-10.
 */
@EActivity
public class AASQLiteActivity extends Activity {

    @App
    Context context;

    private BaseSQLiteOpenHelper baseSQLiteOpenHelper = new BaseSQLiteOpenHelper(context, Constant.SQLite.DB_NAME, null, Constant.SQLite.DB_VERSION);

}
