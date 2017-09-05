package com.cerezaconsulting.reciclappcalidad.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by miguel on 13/06/17.
 */

public class BenefitEntity implements Parcelable {
    private int beneficio_id;
    private String nombre;
    private String descripcion;
    private int req_puntos;
    private String tipo;
    private int cantidad;
    private int sponsorId;
    private int estado;
    private String created_at;
    private String updated_at;

    public BenefitEntity (String nombre,int cantidad){
        this.nombre=nombre;
        this.cantidad=cantidad;
    }

    protected BenefitEntity(Parcel in) {
        beneficio_id = in.readInt();
        nombre = in.readString();
        descripcion = in.readString();
        req_puntos = in.readInt();
        tipo = in.readString();
        cantidad = in.readInt();
        sponsorId = in.readInt();
        estado = in.readInt();
        created_at = in.readString();
        updated_at = in.readString();
    }

    public static final Creator<BenefitEntity> CREATOR = new Creator<BenefitEntity>() {
        @Override
        public BenefitEntity createFromParcel(Parcel in) {
            return new BenefitEntity(in);
        }

        @Override
        public BenefitEntity[] newArray(int size) {
            return new BenefitEntity[size];
        }
    };

    public int getBeneficioId() {
        return beneficio_id;
    }

    public void setBeneficioId(int beneficio_id) {
        this.beneficio_id = beneficio_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getReqPuntos() {
        return req_puntos;
    }

    public void setReqPuntos(int req_puntos) {
        this.req_puntos = req_puntos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(beneficio_id);
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeInt(req_puntos);
        dest.writeString(tipo);
        dest.writeInt(cantidad);
        dest.writeInt(sponsorId);
        dest.writeInt(estado);
        dest.writeString(created_at);
        dest.writeString(updated_at);
    }
}
