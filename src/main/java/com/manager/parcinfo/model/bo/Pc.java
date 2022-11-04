package com.manager.parcinfo.model.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pc extends Materiel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Pid;
    private String TypePC;
    private String osName;
    private String osVersion;
    private String osManufacterer;
    private String systemType;
    private String processorType;
    private String biosVersion;
    private String Ram;
    private String disk;

    public Pc() {
    }

    public Pc(String typePC, String osName, String osVersion, String osManufacterer, String systemType, String processorType, String biosVersion, String ram, String disk) {
        super();
        TypePC = typePC;
        this.osName = osName;
        this.osVersion = osVersion;
        this.osManufacterer = osManufacterer;
        this.systemType = systemType;
        this.processorType = processorType;
        this.biosVersion = biosVersion;
        Ram = ram;
        this.disk = disk;
    }

    public Pc(String brand, String model, Date dateRequis, String state, String typePC, String osName, String osVersion, String osManufacterer, String systemType, String processorType, String biosVersion, String ram, String disk) {
        super(brand, model, dateRequis, state);
        TypePC = typePC;
        this.osName = osName;
        this.osVersion = osVersion;
        this.osManufacterer = osManufacterer;
        this.systemType = systemType;
        this.processorType = processorType;
        this.biosVersion = biosVersion;
        Ram = ram;
        this.disk = disk;
    }

    public Long getPid() {
        return Pid;
    }

    public void setPid(Long pid) {
        Pid = pid;
    }

    public String getTypePC() {
        return TypePC;
    }

    public void setTypePC(String typePC) {
        TypePC = typePC;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsManufacterer() {
        return osManufacterer;
    }

    public void setOsManufacterer(String osManufacterer) {
        this.osManufacterer = osManufacterer;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public String getBiosVersion() {
        return biosVersion;
    }

    public void setBiosVersion(String biosVersion) {
        this.biosVersion = biosVersion;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String ram) {
        Ram = ram;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }
}
