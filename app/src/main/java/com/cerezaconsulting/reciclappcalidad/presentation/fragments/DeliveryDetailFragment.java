package com.cerezaconsulting.reciclappcalidad.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.core.BaseFragment;
import com.cerezaconsulting.reciclappcalidad.data.entities.DeliveryEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 30/06/17.
 */

public class DeliveryDetailFragment extends BaseFragment {

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_supervisor)
    TextView tvSupervisor;
    @BindView(R.id.tv_collection_point)
    TextView tvCollectionPoint;
    Unbinder unbinder;
    @BindView(R.id.rv_delivery_list)
    RecyclerView rvDeliveryList;
    @BindView(R.id.tv_total_points)
    TextView tvTotalPoints;

    private DeliveryEntity deliveryEntity;

    public static DeliveryDetailFragment newInstance(Bundle bundle) {
        DeliveryDetailFragment fragment = new DeliveryDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deliveryEntity = (DeliveryEntity) getArguments().getSerializable("delivery");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_delivery_description, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvDate.setText(deliveryEntity.getDate());
        tvSupervisor.setText(deliveryEntity.getGatheringEntity().getDirection());
        tvCollectionPoint.setText(deliveryEntity.getGatheringEntity().getName());
        tvTotalPoints.setText(deliveryEntity.getTotal_points()+"");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
