package com.juranoaa.setting;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;

/**
 * Created by SungGeun on 2015-10-08.
 */
@EActivity
public class AANextActivity extends Activity{

    private static final String TAG = AANextActivity_.class.getSimpleName();

    @Extra("myStringExtra")
    String myStringExtra;

    @AfterExtras
    void after(){
        Log.d(TAG, myStringExtra);

        Intent intent = new Intent();
        intent.putExtra("myStringExtra", TAG);
        this.setResult(RESULT_OK, intent);
        this.finish();
    }

}
