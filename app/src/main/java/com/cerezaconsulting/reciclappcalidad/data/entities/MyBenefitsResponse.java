package com.cerezaconsulting.reciclappcalidad.data.entities;

/**
 * Created by Jair Barzola on 23-Sep-17.
 */

public class MyBenefitsResponse {
    private int beneficio_id;
    private String nombre;
    private String descripcion;
    private int req_puntos;
    private String tipo;
    private int cantidad;
    private int sponsor_id;
    private int estado;
    private String created_at;
    private String updated_at;
    private PivotEntity pivot;

    public int getBeneficio_id() {
        return beneficio_id;
    }

    public void setBeneficio_id(int beneficio_id) {
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

    public int getReq_puntos() {
        return req_puntos;
    }

    public void setReq_puntos(int req_puntos) {
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

    public int getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(int sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public PivotEntity getPivot() {
        return pivot;
    }

    public void setPivot(PivotEntity pivot) {
        this.pivot = pivot;
    }
}
