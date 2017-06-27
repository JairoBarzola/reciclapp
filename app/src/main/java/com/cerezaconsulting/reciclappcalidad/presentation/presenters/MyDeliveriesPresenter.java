package com.cerezaconsulting.reciclappcalidad.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.MyDeliveriesContract;

/**
 * Created by miguel on 21/06/17.
 */

public class MyDeliveriesPresenter implements MyDeliveriesContract.Presenter {

    private MyDeliveriesContract.View mView;
    private Context context;
    private SessionManager sessionManager;

    public MyDeliveriesPresenter(MyDeliveriesContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
