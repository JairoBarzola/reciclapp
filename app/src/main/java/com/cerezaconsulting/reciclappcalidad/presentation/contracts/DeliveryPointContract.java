package com.cerezaconsulting.reciclappcalidad.presentation.contracts;

import com.cerezaconsulting.reciclappcalidad.core.BasePresenter;
import com.cerezaconsulting.reciclappcalidad.core.BaseView;
import com.cerezaconsulting.reciclappcalidad.data.entities.DeliveryPointEntity;

import java.util.ArrayList;

/**
 * Created by miguel on 20/06/17.
 */

public interface DeliveryPointContract {
    //interfaces para el modelo Vista-Presentador
    interface View extends BaseView<Presenter>{
        void getDeliveryPoints(ArrayList<DeliveryPointEntity> list);
    }
    interface Presenter extends BasePresenter{

    }
}
