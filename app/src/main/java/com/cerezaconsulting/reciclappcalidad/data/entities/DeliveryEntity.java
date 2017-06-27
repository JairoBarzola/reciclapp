package com.cerezaconsulting.reciclappcalidad.data.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by miguel on 20/06/17.
 */

public class DeliveryEntity implements Serializable {
    @SerializedName("entrega_id")
    private String id;
    @SerializedName("total_cantidad")
    private int total_quantity;
    @SerializedName("total_puntos")
    private int total_points;
    @SerializedName("created_at")
    private String date;
    @SerializedName("acopio")
    private GatheringEntity gatheringEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public int getTotal_points() {
        return total_points;
    }

    public void setTotal_points(int total_points) {
        this.total_points = total_points;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public GatheringEntity getGatheringEntity() {
        return gatheringEntity;
    }

    public void setGatheringEntity(GatheringEntity gatheringEntity) {
        this.gatheringEntity = gatheringEntity;
    }
}
