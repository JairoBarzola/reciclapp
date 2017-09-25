package com.cerezaconsulting.reciclappcalidad.presentation.contracts;

import com.cerezaconsulting.reciclappcalidad.core.BasePresenter;
import com.cerezaconsulting.reciclappcalidad.core.BaseView;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;

/**
 * Created by miguel on 18/06/17.
 */

public interface RegisterContract {
    //interfaces para el modelo Vista-Presentador
    interface View extends BaseView<Presenter>{
        void registerSuccessfully();
    }
    interface Presenter extends BasePresenter{
        void registerUser(UserEntity userEntity);
    }
}
