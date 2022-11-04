package com.manager.parcinfo.model.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class Materiel implements Serializable {

    private String brand;
    private String model;
    private Date dateRequis;
    private String State;

    public Materiel(String brand, String model, Date dateRequis, String state) {
        this.brand = brand;
        this.model = model;
        this.dateRequis = dateRequis;
        State = state;
    }

    public Materiel() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDateRequis() {
        return dateRequis;
    }

    public void setDateRequis(Date dateRequis) {
        this.dateRequis = dateRequis;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
