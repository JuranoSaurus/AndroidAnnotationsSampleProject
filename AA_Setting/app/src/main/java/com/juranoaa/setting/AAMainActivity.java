package com.juranoaa.setting;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

import java.util.Date;

/**
 * Created by SungGeun on 2015-08-29.
 */
@EActivity(R.layout.main)
public class AAMainActivity extends Activity{

    @StringRes
    String hello;

    @ViewById
    TextView helloTextView;

    @AfterViews
    void afterViews() {
        Date now = new Date();
        String helloMessage = String.format(hello, now.toString());
        helloTextView.setText(helloMessage);
    }

    @Click
    void button(){
        AANextActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).myStringExtra("text").start();
    }


}
