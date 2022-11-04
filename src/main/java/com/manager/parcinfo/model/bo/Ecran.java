package com.manager.parcinfo.model.bo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Ecran extends Materiel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Eid;

    public Ecran() {
        super();
    }

    public Ecran(String brand, String model, Date dateRequis, String state, Long eid) {
        super(brand, model, dateRequis, state);
        Eid = eid;
    }

    public Long getEid() {
        return Eid;
    }

    public void setEid(Long eid) {
        Eid = eid;
    }
}
