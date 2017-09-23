package com.cerezaconsulting.reciclappcalidad.data.repositories.remote.request;

import com.cerezaconsulting.reciclappcalidad.data.entities.BenefitEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.BusinessEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.RegisterResponse;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserEntity;
import com.cerezaconsulting.reciclappcalidad.data.entities.UserResponse;
import com.cerezaconsulting.reciclappcalidad.data.entities.trackholders.EntityTrackHolder;
import com.cerezaconsulting.reciclappcalidad.data.repositories.remote.ApiConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by miguel on 29/06/17.
 */

public interface BenefitsRequest {

    @GET(ApiConstants.BENEFITS)
    Call<List<BusinessEntity>> getBusinessBenefits(@Header("Authorization") String token,
                                                   @Header("Accept") String json);

    @GET(ApiConstants.USER_BENEFITS)
    Call<UserResponse> getUserBenefits(@Header("Authorization") String token,
                                       @Header("Accept") String json, @Path("id") String id);
    @POST(ApiConstants.USER_ASSING_BENEFIT)
    Call<RegisterResponse> assignBenefit(@Header("Authorization") String token,
                                         @Header("Accept") String json, @Path("id") String id, @Path("bf_id") String bf_id);
}
