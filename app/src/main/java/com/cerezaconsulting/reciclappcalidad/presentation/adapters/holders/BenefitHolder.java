package com.cerezaconsulting.reciclappcalidad.presentation.adapters.holders;

import android.view.View;
import android.widget.TextView;

import com.cerezaconsulting.reciclappcalidad.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jair Barzola on 04-Sep-17.
 */

public class BenefitHolder extends ChildViewHolder {
    @BindView(R.id.tv_benefit_name)
    public TextView tvBenefitName;
    @BindView(R.id.tv_benefit_total)
    public TextView tvBenefitTotal;

    public BenefitHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

}
