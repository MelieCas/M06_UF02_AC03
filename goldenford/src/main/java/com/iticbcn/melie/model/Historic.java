package com.iticbcn.melie.model;

import java.io.Serializable;
import java.sql.Date;

public class Historic implements Serializable {
    private int id;
    private Date data_inici;
    private Date data_fi;
    private String comentaris;

    public Historic(Date data_inici, Date data_fi, String comentaris) {
        this.data_inici = data_inici;
        this.data_fi = data_fi;
        this.comentaris = comentaris;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getData_inici() {
        return data_inici;
    }
    public void setData_inici(Date data_inici) {
        this.data_inici = data_inici;
    }
    public Date getData_fi() {
        return data_fi;
    }
    public void setData_fi(Date data_fi) {
        this.data_fi = data_fi;
    }
    public String getComentaris() {
        return comentaris;
    }
    public void setComentaris(String comentaris) {
        this.comentaris = comentaris;
    }
}
