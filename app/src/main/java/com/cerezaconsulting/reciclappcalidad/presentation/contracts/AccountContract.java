package com.cerezaconsulting.reciclappcalidad.presentation.contracts;

import com.cerezaconsulting.reciclappcalidad.core.BasePresenter;
import com.cerezaconsulting.reciclappcalidad.core.BaseView;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;

/**
 * Created by miguel on 29/06/17.
 */

public interface AccountContract {
    interface View extends BaseView<Presenter>{
        void loadUser(UserEntity userEntity);
    }
    interface Presenter extends BasePresenter{
        void closeSession();
    }
}
