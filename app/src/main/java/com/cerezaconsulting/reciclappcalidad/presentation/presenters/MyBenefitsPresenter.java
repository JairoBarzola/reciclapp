package com.cerezaconsulting.reciclappcalidad.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.BusinessEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.DeliveryEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserResponse;
import com.cerezaconsulting.reciclappcalidad.data.entities.trackholders.EntityTrackHolder;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ApiConstants;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.BenefitsRequest;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.DeliveriesRequest;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.MyBenefitsContract;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        mView.setLoadingIndicator(true);
        String token = sessionManager.getUserToken();
        UserEntity userEntity = sessionManager.getUserEntity();
        BenefitsRequest request = ServiceFactory.createService(BenefitsRequest.class);
        Call<UserResponse> call = request.getUserBenefits("Bearer "+token, ApiConstants.APP_JSON,userEntity.getUser_id());
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                UserResponse userResponse = response.body();
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.loadBenefits(userResponse.getBenefits());
                }
                else{
                    mView.setMessageError(context.getString(R.string.there_was_an_error_try_it_later));
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.setMessageError(context.getString(R.string.no_server_connection_try_it_later));
            }
        });

    }
}
