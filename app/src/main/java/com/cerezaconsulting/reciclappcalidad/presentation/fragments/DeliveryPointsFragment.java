package com.cerezaconsulting.reciclappcalidad.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.core.BaseFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 13/06/17.
 */

public class DeliveryPointsFragment extends BaseFragment implements OnMapReadyCallback {

    @BindView(R.id.mv_delivery_point)
    MapView mvDeliveryPoint;
    Unbinder unbinder;

    private GoogleMap googleMap;

    public static DeliveryPointsFragment newInstance() {
        return new DeliveryPointsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_delivery_points, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvDeliveryPoint.onCreate(savedInstanceState);
        mvDeliveryPoint.getMapAsync(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mvDeliveryPoint.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        mvDeliveryPoint.onResume();
    }

    @Override
    public void onPause() {
        mvDeliveryPoint.onPause();
        super.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mvDeliveryPoint.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap  = googleMap;
    }
}
