package com.cerezaconsulting.reciclappcalidad.presentation.contracts;

import com.cerezaconsulting.reciclappcalidad.core.BasePresenter;
import com.cerezaconsulting.reciclappcalidad.core.BaseView;
import com.cerezaconsulting.reciclappcalidad.data.entities.BenefitEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.BusinessEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.MyBenefitsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguel on 29/06/17.
 */

public interface MyBenefitsContract {
    //interfaces para el modelo Vista-Presentador
    interface View extends BaseView<Presenter>{
        void loadBenefits(List<MyBenefitsResponse> list);
    }
    interface Presenter extends BasePresenter{

    }
}
