package com.juranoaa.setting;

import android.app.Activity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by SungGeun on 2015-08-29.
 */
@EActivity(R.layout.activity_login)
public class AALoginActivity extends Activity {

    @ViewById(R.id.email)
    AutoCompleteTextView mEmailView;
    @ViewById(R.id.password)
    EditText mPasswordView;
    @ViewById(R.id.login_form)
    View mLoginFormView;
    @ViewById(R.id.login_progress)
    View mProgressView;

    @Click(R.id.email_sign_in_button)
    public void onClick(){

    }
}
