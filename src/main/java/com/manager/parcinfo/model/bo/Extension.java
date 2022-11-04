package com.manager.parcinfo.model.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Extension implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Eid;
    private String Ename;
    private String city;

    @ManyToOne
    @JoinColumn(name = "Sid", nullable = false)
    private Societe company;

    @ManyToMany(targetEntity = Departement.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "extensiondepartment",
            joinColumns = { @JoinColumn(name = "Eid") },
            inverseJoinColumns = { @JoinColumn(name = "Did") })
    private List<Departement> departments;

    public Extension(String ename, String city) {
        Ename = ename;
        this.city = city;
    }

    public Extension(String ename, String city, Societe company) {
        Ename = ename;
        this.city = city;
        this.company = company;
    }

    public Extension() {
    }

    public Long getEid() {
        return Eid;
    }

    public void setEid(Long eid) {
        Eid = eid;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Societe getCompany() {
        return company;
    }

    public void setCompany(Societe company) {
        this.company = company;
    }

    public List<Departement> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departement> departments) {
        this.departments = departments;
    }
}
