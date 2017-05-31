package com.cerezaconsulting.reciclappcalidad.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.core.BaseActivity;
import com.cerezaconsulting.reciclappcalidad.presentation.fragments.ReceivedBenefitQRFragment;
import com.cerezaconsulting.reciclappcalidad.presentation.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miguel on 30/05/17.
 */

public class ReceivedBenefitQrActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle(R.string.make_a_delivery);
        ab.setDisplayHomeAsUpEnabled(true);

        ReceivedBenefitQRFragment fragment = (ReceivedBenefitQRFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if(fragment == null){
            fragment = ReceivedBenefitQRFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.body);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
