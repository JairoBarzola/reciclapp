package com.cerezaconsulting.reciclappcalidad.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.BenefitEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.BusinessEntity;
import com.cerezaconsulting.reciclappcalidad.presentation.adapters.holders.BenefitHolder;
import com.cerezaconsulting.reciclappcalidad.presentation.adapters.holders.BusinessHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Jair Barzola on 04-Sep-17.
 */

public class RecyclerAdapterBenefits extends ExpandableRecyclerViewAdapter<BusinessHolder,BenefitHolder> {

    Context context;
    public RecyclerAdapterBenefits(Context context,List<? extends ExpandableGroup> groups) {
        super(groups);
        this.context=context;
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
    public void onBindChildViewHolder(BenefitHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final BenefitEntity benefit = ((BusinessEntity) group).getItems().get(childIndex);
        holder.tvBenefitName.setText(benefit.getNombre());
        holder.tvBenefitTotal.setText(String.valueOf(benefit.getCantidad())+" restantes");
    }
    @Override
    public void onBindGroupViewHolder(BusinessHolder holder, int flatPosition, ExpandableGroup group) {
        holder.bind(context,group);
    }
}
