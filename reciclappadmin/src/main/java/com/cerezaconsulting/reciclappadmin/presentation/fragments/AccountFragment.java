package com.cerezaconsulting.reciclappadmin.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cerezaconsulting.reciclappadmin.R;
import com.cerezaconsulting.reciclappadmin.core.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 13/06/17.
 */

public class AccountFragment extends BaseFragment {

    @BindView(R.id.iv_profile)
    ImageView ivProfile;
    @BindView(R.id.tv_full_name)
    TextView tvFullName;
    @BindView(R.id.tv_document_number)
    TextView tvDocumentNumber;
    @BindView(R.id.tv_birth_date)
    TextView tvBirthDate;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    Unbinder unbinder;

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
