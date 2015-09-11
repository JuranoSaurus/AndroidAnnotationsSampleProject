package com.juranoaa.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by SungGeun on 2015-08-29.
 */
public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
