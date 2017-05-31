package com.cerezaconsulting.reciclappcalidad.presentation.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cerezaconsulting.reciclappcalidad.R;
import com.cerezaconsulting.reciclappcalidad.core.BaseFragment;
import com.cerezaconsulting.reciclappcalidad.presentation.utils.BarcodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 30/05/17.
 */

public class ReceivedBenefitQRFragment extends BaseFragment {

    @BindView(R.id.fl_content_frame)
    ImageView flContentFrame;
    Unbinder unbinder;

    public static ReceivedBenefitQRFragment newInstance() {
        return new ReceivedBenefitQRFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_received_benefit, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bitmap bitmap = BarcodeUtils.encodeAsBitmapQR("Joséufiyufy865t87t7t87t",250);
        flContentFrame.setImageBitmap(bitmap);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
