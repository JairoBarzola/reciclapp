package com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request;

import com.cerezaconsulting.reciclappcalidad.data.entities.DeliveryEntity;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ApiConstants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by miguel on 21/06/17.
 */

public interface DeliveriesRequest {
    @GET(ApiConstants.USER_DELIVERIES)
    Call<ArrayList<DeliveryEntity>> getMyDeliveries(@Header("Authorization") String token, @Header("Accept") String accept,
                                                    @Path("id") String userId);

}
