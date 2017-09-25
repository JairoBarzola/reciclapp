package com.cerezaconsulting.reciclappcalidad.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.DeliveryEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ApiConstants;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.DeliveriesRequest;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.MyDeliveriesContract;
import com.cerezaconsulting.reciclappcalidad.presentation.presenters.communicators.CommunicatorEntity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by miguel on 21/06/17.
 */

public class MyDeliveriesPresenter implements MyDeliveriesContract.Presenter,CommunicatorEntity<DeliveryEntity> {

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
        //Metodo para obtener la lista de entregas
        //DeliveriesRequest se encuentra data/remote/request
        mView.setLoadingIndicator(true);
        String token = sessionManager.getUserToken();
        UserEntity userEntity = sessionManager.getUserEntity();
        DeliveriesRequest request = ServiceFactory.createService(DeliveriesRequest.class);
        Call<ArrayList<DeliveryEntity>> call = request.getMyDeliveries("Bearer "+token, ApiConstants.APP_JSON,userEntity.getUser_id());
        call.enqueue(new Callback<ArrayList<DeliveryEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<DeliveryEntity>> call, Response<ArrayList<DeliveryEntity>> response) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.getMyDeliveries(response.body());
                }
                else{
                    mView.setMessageError(context.getString(R.string.there_was_an_error_try_it_later));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DeliveryEntity>> call, Throwable t) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.setMessageError(context.getString(R.string.no_server_connection_try_it_later));
            }
        });
    }

    @Override
    public void onClick(DeliveryEntity entity) {
        mView.deliveryDetail(entity);
    }
}
