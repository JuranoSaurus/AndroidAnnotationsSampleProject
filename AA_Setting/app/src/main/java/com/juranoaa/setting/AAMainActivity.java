package com.juranoaa.setting;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
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
        AANextActivity_.intent(this).myStringExtra(TAG).startForResult(NEXT_REQUEST_CODE);
    }

    @OnActivityResult(NEXT_REQUEST_CODE)
    void onResult(int resultCode, @OnActivityResult.Extra String myStringExtra){
        if(resultCode == RESULT_OK) {
            Log.d(TAG, myStringExtra);
        }
    }
}
