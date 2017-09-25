package com.cerezaconsulting.reciclappcalidad.presentation.presenters;

import android.content.Context;
import android.util.Log;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.AccessTokenEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ApiConstants;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.UserRequest;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.LoginContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by miguel on 18/06/17.
 */

public class LoginPresenter implements LoginContract.Presenter{
    private LoginContract.View mView;
    private Context context;
    private SessionManager sessionManager;

    public LoginPresenter(LoginContract.View mView,Context context) {
        this.mView = mView;
        this.context = context;
        sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }

    @Override
    public void login(String email, String password) {
        //Metodo para obtener el token
        //UserRequest se encuentra data/remote/request
        mView.setLoadingIndicator(true);
        UserRequest userRequest = ServiceFactory.createService(UserRequest.class);
        Call<AccessTokenEntity> call = userRequest.login(email,password, ApiConstants.GRANT_TYPE,ApiConstants.CLIENT_ID,ApiConstants.CLIENT_SECRET);
        call.enqueue(new Callback<AccessTokenEntity>() {
            @Override
            public void onResponse(Call<AccessTokenEntity> call, Response<AccessTokenEntity> response) {

                Log.i("Response :",response.message());
                if(!mView.isActive()){
                    return;
                }
                if(response.isSuccessful()){
                    getAccount(response.body());
                }
                else{
                    mView.setLoadingIndicator(false);
                    mView.setMessageError(context.getString(R.string.there_was_an_error_try_it_later));
                }
            }

            @Override
            public void onFailure(Call<AccessTokenEntity> call, Throwable t) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.setMessageError(context.getString(R.string.no_server_connection_try_it_later));
            }
        });
    }

    private void getAccount(final AccessTokenEntity accessTokenEntity){
        //Metodo para obtener el los datos del colaborador
        //UserRequest se encuentra data/remote/request
        UserRequest userRequest = ServiceFactory.createService(UserRequest.class);
        Call<UserEntity> call = userRequest.getUser("Bearer "+accessTokenEntity.getAccess_token());
        call.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                if(!mView.isActive()){
                    return;
                }
                if(response.isSuccessful()){
                    openSession(accessTokenEntity,response.body());
                }
                else{
                    mView.setLoadingIndicator(false);
                    mView.setMessageError(context.getString(R.string.there_was_an_error_try_it_later));
                }
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.setMessageError(context.getString(R.string.no_server_connection_try_it_later));
            }
        });
    }

    private void openSession(AccessTokenEntity accessTokenEntity, UserEntity userEntity){
        mView.setLoadingIndicator(false);
        sessionManager.openSession(accessTokenEntity.getAccess_token(),userEntity);
        mView.loginSuccessfully();
    }

    @Override
    public void start() {

    }
}
