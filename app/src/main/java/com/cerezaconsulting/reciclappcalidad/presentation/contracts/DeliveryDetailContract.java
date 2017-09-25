package com.cerezaconsulting.reciclappcalidad.presentation.contracts;

import com.cerezaconsulting.reciclappcalidad.core.BasePresenter;
import com.cerezaconsulting.reciclappcalidad.core.BaseView;
import com.cerezaconsulting.reciclappcalidad.data.entities.DeliveryEntity;

/**
 * Created by miguel on 4/07/17.
 */

public interface DeliveryDetailContract {
    //interfaces para el modelo Vista-Presentador
    interface View extends BaseView<Presenter> {
        void getDeliveryDetail(DeliveryEntity deliveryEntity);
    }
    interface Presenter extends BasePresenter{
        void loadDeliveryDetail(DeliveryEntity deliveryEntity);
    }
}
