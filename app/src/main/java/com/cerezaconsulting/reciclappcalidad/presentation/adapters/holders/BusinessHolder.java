package com.cerezaconsulting.reciclappcalidad.presentation.adapters.holders;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;



import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.data.entities.BusinessEntity;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jair Barzola on 04-Sep-17.
 */

public class BusinessHolder extends GroupViewHolder {
    @BindView(R.id.tv_business_name) TextView tvBusinessName;
    @BindView(R.id.tv_business_benefits)  TextView tvBusinessBenefits;
    @BindView(R.id.arrow_down) ImageView arrowDown;

    public BusinessHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void bind(Context context, ExpandableGroup business) {
        if(business instanceof BusinessEntity){
            tvBusinessName.setText(String.valueOf(((BusinessEntity) business).getRazon_social()));
            tvBusinessBenefits.setText(String.valueOf(((BusinessEntity) business).getItemCount())+" beneficios");
        }
    }

    @Override
    public void expand() {
        super.expand();
        animateExpand();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrowDown.setAnimation(rotate);
    }

    @Override
    public void collapse() {
        super.collapse();
        animateCollapse();
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrowDown.setAnimation(rotate);
    }
}
