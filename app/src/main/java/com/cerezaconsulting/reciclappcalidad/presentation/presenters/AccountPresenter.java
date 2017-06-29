package com.cerezaconsulting.reciclappcalidad.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.AccountContract;

/**
 * Created by miguel on 29/06/17.
 */

public class AccountPresenter implements AccountContract.Presenter {

    private AccountContract.View mView;
    private Context context;
    private SessionManager sessionManager;

    public AccountPresenter(AccountContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        UserEntity userEntity = sessionManager.getUserEntity();
        mView.setLoadingIndicator(true);
        mView.loadUser(userEntity);
        mView.setLoadingIndicator(false);
    }

    @Override
    public void closeSession() {

    }
}
