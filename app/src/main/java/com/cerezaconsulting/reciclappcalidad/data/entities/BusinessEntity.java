package com.cerezaconsulting.reciclappcalidad.data.entities;

import com.google.gson.annotations.SerializedName;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguel on 29/06/17.
 */

public class BusinessEntity extends ExpandableGroup<BenefitEntity>{
    private int sponsor_id;
    private String razon_social;
    private String ruc;
    private String direccion;
    private String telefono;
    private String contacto;
    private String distrito;
    private int estado;
    private String createda_at;
    private String updated_at;
    private List<BenefitEntity> benefits = new ArrayList<>();


    public BusinessEntity(String title, List<BenefitEntity> items) {
        super(title, items);
        //this.razonSocial=title;
        //this.benefits=items;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    public List<BenefitEntity> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<BenefitEntity> benefits) {
        this.benefits = benefits;
    }

    public int getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(int sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getCreateda_at() {
        return createda_at;
    }

    public void setCreateda_at(String createda_at) {
        this.createda_at = createda_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
