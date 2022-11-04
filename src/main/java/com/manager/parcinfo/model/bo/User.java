package com.manager.parcinfo.model.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Uid;
    private String Uname;
    private String UlasteName;
    private String Uemail;
    private String Utele;
    private String Uposte;

    @ManyToOne
    @JoinColumn(name = "Did", nullable = false)
    private Departement workers;

    @ManyToMany(targetEntity = Pc.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "PcUser",
            joinColumns = { @JoinColumn(name = "Uid") },
            inverseJoinColumns = { @JoinColumn(name = "Pid") })
    private List<Pc> pcs;

    @ManyToMany(targetEntity = Ecran.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "EcranUser",
            joinColumns = { @JoinColumn(name = "Uid") },
            inverseJoinColumns = { @JoinColumn(name = "Eid") })
    private List<Ecran> ecrans;

    @ManyToMany(targetEntity = Printer.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "PrinterUser",
            joinColumns = { @JoinColumn(name = "Uid") },
            inverseJoinColumns = { @JoinColumn(name = "Pid") })
    private List<Printer> printers;

    public User() {
    }

    public User(String uname, String ulasteName, String uemail, String utele, String uposte) {
        Uname = uname;
        UlasteName = ulasteName;
        Uemail = uemail;
        Utele = utele;
        Uposte = uposte;
    }

    public User(String uname, String ulasteName, String uemail, String utele, String uposte, Departement workers) {
        Uname = uname;
        UlasteName = ulasteName;
        Uemail = uemail;
        Utele = utele;
        Uposte = uposte;
        this.workers = workers;
    }

    public Long getUid() {
        return Uid;
    }

    public void setUid(Long uid) {
        Uid = uid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUlasteName() {
        return UlasteName;
    }

    public void setUlasteName(String ulasteName) {
        UlasteName = ulasteName;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String uemail) {
        Uemail = uemail;
    }

    public String getUtele() {
        return Utele;
    }

    public void setUtele(String utele) {
        Utele = utele;
    }

    public String getUposte() {
        return Uposte;
    }

    public void setUposte(String uposte) {
        Uposte = uposte;
    }

    public Departement getWorkers() {
        return workers;
    }

    public void setWorkers(Departement workers) {
        this.workers = workers;
    }
}
