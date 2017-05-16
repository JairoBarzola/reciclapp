package com.cerezaconsulting.reciclappcalidad.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.core.BaseActivity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;

/**
 * Created by miguel on 16/05/17.
 */

public class LoadActivity extends BaseActivity {
    private SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        sessionManager = new SessionManager(getApplicationContext());
        initializeView();
    }

    private void initializeView(){
        next(this, null, sessionManager.isLogin() ? MainActivity.class : LoginActivity.class, true);
    }
}
