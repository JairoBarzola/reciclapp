package com.cerezaconsulting.reciclappcalidad.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.core.BaseActivity;
import com.cerezaconsulting.reciclappcalidad.presentation.fragments.LoginFragment;
import com.cerezaconsulting.reciclappcalidad.presentation.presenters.LoginPresenter;
import com.cerezaconsulting.reciclappcalidad.presentation.utils.ActivityUtils;

/**
 * Created by miguel on 16/05/17.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if(loginFragment==null){
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),loginFragment,R.id.body);
        }
        new LoginPresenter(loginFragment,getApplicationContext());
    }

}
