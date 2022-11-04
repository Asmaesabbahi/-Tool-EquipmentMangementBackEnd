package com.manager.parcinfo.model.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Printer extends Materiel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Pid;
    private String type;
    private String EtatToner;

    @ManyToMany(targetEntity = Toner.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "PrinterFilling",
            joinColumns = { @JoinColumn(name = "Pid") },
            inverseJoinColumns = { @JoinColumn(name = "Tid") })
    private List<Toner> toners;

    public Printer() {
    }

    public Printer(String type, String etatToner) {
        super();
        this.type = type;
        EtatToner = etatToner;
    }

    public Printer(String brand, String model, Date dateRequis, String state, String type, String etatToner) {
        super(brand, model, dateRequis, state);
        this.type = type;
        EtatToner = etatToner;
    }

    public Long getPid() {
        return Pid;
    }

    public void setPid(Long pid) {
        Pid = pid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtatToner() {
        return EtatToner;
    }

    public void setEtatToner(String etatToner) {
        EtatToner = etatToner;
    }
}
