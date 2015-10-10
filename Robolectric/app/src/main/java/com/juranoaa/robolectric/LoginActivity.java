package com.juranoaa.robolectric;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by SungGeun on 2015-10-11.
 */
public class LoginActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

}
