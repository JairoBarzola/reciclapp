package com.cerezaconsulting.reciclappcalidad.presentation.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.BenefitEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.BusinessEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.DeliveryEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.RegisterResponse;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ApiConstants;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.BenefitsRequest;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request.DeliveriesRequest;
import com.cerezaconsulting.reciclappcalidad.presentation.adapters.holders.BenefitHolder;
import com.cerezaconsulting.reciclappcalidad.presentation.adapters.holders.BusinessHolder;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.Benefits.GetBenefitsPresenter;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.Benefits.GetBenefitsPresenterImpl;
import com.cerezaconsulting.reciclappcalidad.presentation.fragments.GetBenefitsFragment;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jair Barzola on 04-Sep-17.
 */

public class RecyclerAdapterBenefits extends ExpandableRecyclerViewAdapter<BusinessHolder,BenefitHolder> {
    Context context;
    private SessionManager sessionManager;
    public RecyclerAdapterBenefits(Context context,List<? extends ExpandableGroup> groups) {
        super(groups);
        this.context=context;
        sessionManager = new SessionManager(context);
    }
    @Override
    public BusinessHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_business_benefits, parent, false);
        return new BusinessHolder(view);
    }

    @Override
    public BenefitHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_benefit, parent, false);
        return new BenefitHolder(view);
    }

    @Override
    public void onBindChildViewHolder(final BenefitHolder holder, int flatPosition, ExpandableGroup group, final int childIndex) {
        final BenefitEntity benefit = ((BusinessEntity) group).getItems().get(childIndex);
        if(childIndex%2==0){
            holder.relativeLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.green_transparent));
        }else{
            holder.relativeLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.transparent));
        }
        holder.tvBenefitName.setText(benefit.getNombre());
        holder.tvBenefitCantidad.setText(String.valueOf(benefit.getCantidad()));
        holder.tvBenefitTotal.setText(String.valueOf(benefit.getReqPuntos())+"\n puntos requeridos");
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               message(String.valueOf(benefit.getBeneficioId())).show();
            }
        });
    }
    @Override
    public void onBindGroupViewHolder(BusinessHolder holder, int flatPosition, ExpandableGroup group) {
        holder.bind(context,group);
    }

    void assingBenefit(final String bf_id){
        String token = sessionManager.getUserToken();
        final UserEntity userEntity = sessionManager.getUserEntity();
        final BenefitsRequest request = ServiceFactory.createService(BenefitsRequest.class);
        Call<RegisterResponse> call = request.assignBenefit("Bearer "+token, ApiConstants.APP_JSON,userEntity.getUser_id(),bf_id);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse = response.body();
                if(response.isSuccessful()){
                    if(response.isSuccessful()){
                        if(registerResponse.getMensaje()=="El beneficio fue registrado."){
                            Toast.makeText(context,registerResponse.getMensaje(),Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(context,registerResponse.getMensaje(),Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(context,R.string.there_was_an_error_try_it_later,Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(context,R.string.there_was_an_error_try_it_later,Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(context,R.string.there_was_an_error_try_it_later,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public AlertDialog message(final String bf_id){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("¿Desea canjear este beneficio?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                assingBenefit(bf_id);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder.create();
    }


}
