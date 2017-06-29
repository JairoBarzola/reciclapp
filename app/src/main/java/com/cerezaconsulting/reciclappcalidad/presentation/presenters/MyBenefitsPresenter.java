package com.cerezaconsulting.reciclappcalidad.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.MyBenefitsContract;

/**
 * Created by miguel on 29/06/17.
 */

public class MyBenefitsPresenter implements MyBenefitsContract.Presenter {

    private MyBenefitsContract.View mView;
    private Context context;
    private SessionManager sessionManager;

    public MyBenefitsPresenter(MyBenefitsContract.View mView, Context context){
        this.mView = mView;
        this.context = context;
        sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
