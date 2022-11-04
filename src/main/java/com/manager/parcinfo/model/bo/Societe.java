package com.manager.parcinfo.model.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Societe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Sid;
    private String SName;

    @OneToMany(mappedBy ="company", cascade = {CascadeType.ALL})
    private List<Extension> Extensions;

    public Societe(String SName) {
        this.SName = SName;
    }

    public Societe() {
    }

    public Long getSid() {
        return Sid;
    }

    public void setSid(Long sid) {
        Sid = sid;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

}
