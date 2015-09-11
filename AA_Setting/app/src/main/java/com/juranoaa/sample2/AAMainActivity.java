package com.juranoaa.sample2;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
/**
 * Created by SungGeun on 2015-08-29.
 */
@EActivity(R.layout.activity_main)
public class AAMainActivity extends Activity{

    private static final String LOG_TAG = "AAMainActivity";

    // ~ 1. intent get success
    @Click(R.id.test_intent_1)
    public void testIntent1() {
        Log.d(LOG_TAG, "test_intent_1");
        Intent intent = AALoginActivity_.intent(AAMainActivity.this).get();
        startActivity(intent);
        //startActivity(this, AALoginActivity_.class);
    }

    @Click(R.id.test_intent_2)
    public void testIntent2(){
        Log.d(LOG_TAG, "test_intent_2");
        // TODO "Error FLAG_ACTIVITY_NEW_TASK"
        // AALoginActivity_.intent(getApplicationContext()).start();
        AALoginActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
    }

}
