package com.cerezaconsulting.reciclappcalidad.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.DeliveryEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ApiConstants;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.DeliveriesRequest;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.DeliveryDetailContract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by miguel on 4/07/17.
 */

public class DeliveryDetailPresenter implements DeliveryDetailContract.Presenter{

    private DeliveryDetailContract.View mView;
    private Context context;
    private SessionManager sessionManager;

    public DeliveryDetailPresenter(DeliveryDetailContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }

    @Override
    public void loadDeliveryDetail(DeliveryEntity deliveryEntity) {
        mView.setLoadingIndicator(true);
        //Metodo para obtener los detalles de la entrega
        //DeliveriesRequest se encuentra data/remote/request
        String token = sessionManager.getUserToken();
        UserEntity userEntity = sessionManager.getUserEntity();
        DeliveriesRequest deliveriesRequest = ServiceFactory.createService(DeliveriesRequest.class);
        Call<ArrayList<DeliveryEntity>> call = deliveriesRequest.getDescripcion("Bearer "+token, ApiConstants.APP_JSON,userEntity.getUser_id(),deliveryEntity.getId());
        call.enqueue(new Callback<ArrayList<DeliveryEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<DeliveryEntity>> call, Response<ArrayList<DeliveryEntity>> response) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.getDeliveryDetail(response.body().get(0));
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
    public void start() {

    }
}
