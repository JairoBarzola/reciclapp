package com.cerezaconsulting.reciclappcalidad.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappcalidad.data.entities.AccessTokenEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.UserRequest;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.RegisterContract;

import retrofit2.Call;

/**
 * Created by miguel on 18/06/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mView;
    private Context context;
    private SessionManager sessionManager;

    public RegisterPresenter(RegisterContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }

    @Override
    public void registerUser(UserEntity userEntity) {
        mView.setLoadingIndicator(true);
        UserRequest userRequest = ServiceFactory.createService(UserRequest.class);
        Call<AccessTokenEntity> call = userRequest.registerUser(userEntity.getFirst_name(),userEntity.getLast_name(),userEntity.getEmail())
    }

    @Override
    public void start() {

    }
}
