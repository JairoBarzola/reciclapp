package com.cerezaconsulting.reciclappadmin.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cerezaconsulting.reciclappadmin.R;
import com.cerezaconsulting.reciclappadmin.core.BaseFragment;
import com.cerezaconsulting.reciclappadmin.presentation.activities.ReceivedBenefitActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by miguel on 13/06/17.
 */

public class RegisterDeliveryFragment extends BaseFragment {


    @BindView(R.id.et_paper_quantity)
    EditText etPaperQuantity;
    @BindView(R.id.et_glass_quantity)
    EditText etGlassQuantity;
    @BindView(R.id.et_plastic_quantity)
    EditText etPlasticQuantity;
    @BindView(R.id.btn_read_qr)
    Button btnReadQr;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    Unbinder unbinder;
    @BindView(R.id.btn_make_delivery)
    Button btnMakeDelivery;

    public static RegisterDeliveryFragment newInstance() {
        return new RegisterDeliveryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register_delivery, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_read_qr)
    public void onViewClicked() {
        next(getActivity(),null, ReceivedBenefitActivity.class,false);
    }

    @OnClick(R.id.btn_make_delivery)
    public void onClicked() {
    }
}
