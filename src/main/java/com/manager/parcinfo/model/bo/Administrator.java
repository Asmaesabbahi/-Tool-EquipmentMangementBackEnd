package com.manager.parcinfo.model.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Administrator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Aid;
    private String Aname;
    private String AlasteName;
    private String AuserName;
    private String Apassword;
    private String Aemail;
    private String tele;
    private String Permission;

    @ManyToMany(targetEntity = User.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "usermanager",
            joinColumns = { @JoinColumn(name = "Aid") },
            inverseJoinColumns = { @JoinColumn(name = "Uid") })
    private List<User> users;

    public Administrator(String aname, String alasteName, String auserName, String apassword, String aemail, String tele, String permission) {
        Aname = aname;
        AlasteName = alasteName;
        AuserName = auserName;
        Apassword = apassword;
        Aemail = aemail;
        this.tele = tele;
        Permission = permission;
    }

    public Administrator() {
    }

    public Long getAid() {
        return Aid;
    }

    public void setAid(Long aid) {
        Aid = aid;
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    public String getAlasteName() {
        return AlasteName;
    }

    public void setAlasteName(String alasteName) {
        AlasteName = alasteName;
    }

    public String getAuserName() {
        return AuserName;
    }

    public void setAuserName(String auserName) {
        AuserName = auserName;
    }

    public String getApassword() {
        return Apassword;
    }

    public void setApassword(String apassword) {
        Apassword = apassword;
    }

    public String getAemail() {
        return Aemail;
    }

    public void setAemail(String aemail) {
        Aemail = aemail;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getPermission() {
        return Permission;
    }

    public void setPermission(String permission) {
        Permission = permission;
    }
}
