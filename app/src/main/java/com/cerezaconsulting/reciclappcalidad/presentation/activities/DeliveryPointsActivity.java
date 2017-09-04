package com.cerezaconsulting.reciclappcalidad.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.core.BaseActivity;
import com.cerezaconsulting.reciclappcalidad.presentation.fragments.DeliveryPointsFragment;
import com.cerezaconsulting.reciclappcalidad.presentation.presenters.DeliveryPointsPresenter;
import com.cerezaconsulting.reciclappcalidad.presentation.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miguel on 13/06/17.
 */

public class DeliveryPointsActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(getString(R.string.collection_points));
        ab.setDisplayHomeAsUpEnabled(true);

        DeliveryPointsFragment fragment = (DeliveryPointsFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if(fragment==null){
            fragment = DeliveryPointsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.body);
        }
        new DeliveryPointsPresenter(fragment,getApplicationContext());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        return true;
    }
}
