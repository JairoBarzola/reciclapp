package com.cerezaconsulting.reciclappcalidad.presentation.contracts;

import com.cerezaconsulting.reciclappcalidad.core.BasePresenter;
import com.cerezaconsulting.reciclappcalidad.core.BaseView;
import com.cerezaconsulting.reciclappcalidad.data.entities.BenefitEntity;

import java.util.ArrayList;

/**
 * Created by miguel on 29/06/17.
 */

public interface MyBenefitsContract {
    interface View extends BaseView<Presenter>{
        void loadBenefits(ArrayList<BenefitEntity> list);
    }
    interface Presenter extends BasePresenter{

    }
}
