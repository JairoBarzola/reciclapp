package com.cerezaconsulting.reciclappcalidad.presentation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.MyBenefitsResponse;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jair Barzola on 23-Sep-17.
 */

public class MyBenefitsAdapter extends RecyclerView.Adapter<MyBenefitsAdapter.ViewHolder> {

    List<MyBenefitsResponse> listMyBenefits = new ArrayList<>();
    Context context;
    public MyBenefitsAdapter(Context context){
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_benefit,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }
    public void setList( List<MyBenefitsResponse> listMyBenefits ) {
        this.listMyBenefits = listMyBenefits;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyBenefitsResponse item = listMyBenefits.get(position);
        holder.myBenefitCantidad.setText(String.valueOf(item.getCantidad()));
        holder.myBenefitName.setText(item.getNombre());
        holder.myBenefitDate.setText(""+item.getPivot().getCreated_at());
    }

    @Override
    public int getItemCount() {
        return listMyBenefits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_my_benefit_cantidad)
        TextView myBenefitCantidad;
        @BindView(R.id.tv_my_benefit_name)
        TextView myBenefitName;
        @BindView(R.id.tv_my_benefit_date)
        TextView myBenefitDate;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
