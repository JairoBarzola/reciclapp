package com.cerezaconsulting.reciclappcalidad.presentation.contracts;

import com.cerezaconsulting.reciclappcalidad.core.BasePresenter;
import com.cerezaconsulting.reciclappcalidad.core.BaseView;

/**
 * Created by miguel on 18/06/17.
 */

public interface LoginContract {
    //interfaces para el modelo Vista-Presentador
    interface View extends BaseView<Presenter>{
        void loginSuccessfully();
    }
    interface Presenter extends BasePresenter{
        void login(String email,String password);
    }
}
