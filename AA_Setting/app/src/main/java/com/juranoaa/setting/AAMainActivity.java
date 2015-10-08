package com.juranoaa.setting;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

import java.util.Date;

/**
 * Created by SungGeun on 2015-10-08.
 */
@EActivity(R.layout.main)
public class AAMainActivity extends Activity{

    private static final String TAG = AAMainActivity_.class.getSimpleName();
    private static final int NEXT_REQUEST_CODE = 0;

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
        // AANextActivity_.intent(this).myStringExtra("text").start();
        AANextActivity_.intent(this).myStringExtra(TAG).startForResult(NEXT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode){
            case NEXT_REQUEST_CODE:
                if(resultCode == RESULT_OK){
                    String myStringExtra = intent.getExtras().getString("myStringExtra");
                    Log.d(TAG, myStringExtra);
                }
                break;
        }
    }
}
