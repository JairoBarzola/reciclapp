package com.cerezaconsulting.reciclappcalidad.presentation.contracts.Benefits;

import android.content.Context;
import android.util.Log;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.BenefitEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.BusinessEntity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ApiConstants;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.BenefitsRequest;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.GetBenefitsContract;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.MyBenefitsContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jair Barzola on 05-Sep-17.
 */

public class GetBenefitsPresenterImpl implements GetBenefitsPresenter {
    GetBenefitsContract.View mView;
    private Context context;
    private SessionManager sessionManager;

    public GetBenefitsPresenterImpl(GetBenefitsContract.View mView, Context context){
        this.mView=mView;
        this.context = context;
        sessionManager = new SessionManager(context);
    }


    @Override
    public void loadData() {
        mView.setLoadingIndicator(true);
        String token = sessionManager.getUserToken();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://198.199.84.9/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BenefitsRequest request = retrofit.create(BenefitsRequest.class);
        Call<List<BusinessEntity>> call = request.getBusinessBenefits("Bearer "+token, ApiConstants.APP_JSON);
        Log.i("Response","Ok");
        call.enqueue(new Callback<List<BusinessEntity>>() {
            @Override
            public void onResponse(Call<List<BusinessEntity>> call, Response<List<BusinessEntity>> response) {
                Log.i("Response", response.message());
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.loadBenefits(response.body());
                }
                else{
                    mView.setMessageError(context.getString(R.string.there_was_an_error_try_it_later));
                }
            }

            @Override
            public void onFailure(Call<List<BusinessEntity>> call, Throwable t) {
                Log.i("Response",t.toString());
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.setMessageError(context.getString(R.string.no_server_connection_try_it_later));
            }
        });
        /*call.enqueue(new Callback<List<BusinessEntity>>() {
            @Override
            public void onResponse(Call<List<BusinessEntity>> call, Response<List<BusinessEntity>> response) {
                Log.i("Response",response.message());
                if(!mView.isActive()){
                   return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.loadBenefits(response.body());
                }
                else{
                    mView.setMessageError(context.getString(R.string.there_was_an_error_try_it_later));
                }
            }

            @Override
            public void onFailure(Call<List<BusinessEntity>> call, Throwable t) {
                Log.i("Response",t.toString());
               if(!mView.isActive()){
                return;
                }
                mView.setLoadingIndicator(false);
                mView.setMessageError(context.getString(R.string.no_server_connection_try_it_later));
            }
        });*/
    }
}
