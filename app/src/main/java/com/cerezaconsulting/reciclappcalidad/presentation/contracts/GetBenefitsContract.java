package com.cerezaconsulting.reciclappcalidad.presentation.contracts;

import com.cerezaconsulting.reciclappcalidad.core.BasePresenter;
import com.cerezaconsulting.reciclappcalidad.core.BaseView;
import com.cerezaconsulting.reciclappcalidad.data.entities.BusinessEntity;

import java.util.ArrayList;

/**
 * Created by miguel on 29/06/17.
 */

public interface GetBenefitsContract {
    interface View extends BaseView<Presenter>{
        void loadBenefits(ArrayList<BusinessEntity> list);
    }
    interface Presenter extends BasePresenter{

    }
}
