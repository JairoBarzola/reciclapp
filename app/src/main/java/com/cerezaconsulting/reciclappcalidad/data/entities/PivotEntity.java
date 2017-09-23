package com.cerezaconsulting.reciclappcalidad.data.entities;

/**
 * Created by Jair Barzola on 23-Sep-17.
 */

public class PivotEntity {
    private int usuario_id;
    private int beneficio_id;
    private String created_at;
    private String updated_at;


    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getBeneficio_id() {
        return beneficio_id;
    }

    public void setBeneficio_id(int beneficio_id) {
        this.beneficio_id = beneficio_id;
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
}
