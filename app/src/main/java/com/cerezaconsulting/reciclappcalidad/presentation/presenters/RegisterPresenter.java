package com.cerezaconsulting.reciclappcalidad.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.AccessTokenEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ApiConstants;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.UserRequest;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.RegisterContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by miguel on 18/06/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mView;
    private Context context;

    public RegisterPresenter(RegisterContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        this.mView.setPresenter(this);
    }

    @Override
    public void registerUser(UserEntity userEntity) {
        //Metodo para registrar un usuario
        //UserRequest se encuentra data/remote/request
        mView.setLoadingIndicator(true);
        UserRequest userRequest = ServiceFactory.createService(UserRequest.class);
        Call<Void> call = userRequest.registerUser(ApiConstants.APP_JSON,userEntity);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.registerSuccessfully();
                }
                else{
                    mView.setMessageError(context.getString(R.string.there_was_an_error_try_it_later));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.setMessageError(context.getString(R.string.no_server_connection_try_it_later));
            }
        });
    }

    @Override
    public void start() {

    }
}
