package com.cerezaconsulting.reciclappcalidad.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.core.BaseActivity;
import com.cerezaconsulting.reciclappcalidad.core.BaseFragment;
import com.cerezaconsulting.reciclappcalidad.data.entities.BusinessEntity;
import com.cerezaconsulting.reciclappcalidad.presentation.adapters.RecyclerAdapterBenefits;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.Benefits.GetBenefitsPresenter;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.Benefits.GetBenefitsPresenterImpl;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.GetBenefitsContract;
import com.cerezaconsulting.reciclappcalidad.presentation.contracts.MyBenefitsContract;
import com.cerezaconsulting.reciclappcalidad.presentation.utils.ProgressDialogCustom;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 30/05/17.
 */

public class GetBenefitsFragment extends BaseFragment implements GetBenefitsContract.View{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_no_items)
    TextView tvNoItems;
    Unbinder unbinder;

    private LinearLayoutManager layoutManager;
    GetBenefitsPresenter presenter;
    private ProgressDialogCustom mProgressDialogCustom;
    RecyclerAdapterBenefits adapter;

    public static GetBenefitsFragment newInstance() {
        return new GetBenefitsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, root);
        presenter = new GetBenefitsPresenterImpl(this,getContext());
        presenter.loadData();
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(),"Cargando...");
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void loadBenefits(List<BusinessEntity> list) {
        adapter= new RecyclerAdapterBenefits(getContext(),list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if(mProgressDialogCustom!=null){
            if(active){
                mProgressDialogCustom.show();
            }
            else{
                mProgressDialogCustom.dismiss();
            }
        }
    }

    @Override
    public void setMessageError(String error) {
        ((BaseActivity)getActivity()).showMessageError(error);
    }

    @Override
    public void setDialogMessage(String message) {
        ((BaseActivity)getActivity()).showMessage(message);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }


    @Override
    public void setPresenter(GetBenefitsContract.Presenter presenter) {

    }

}
