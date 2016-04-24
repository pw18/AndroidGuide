package com.example.model;

/**
 * Created by Administrator on 4/24/2016.
 */
public class DiseasesModel {

    private int id;
    private String name;
    private String sysptom;
    private String cause;
    private String sysptomInstant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSysptom() {
        return sysptom;
    }

    public void setSysptom(String sysptom) {
        this.sysptom = sysptom;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getSysptomInstant() {
        return sysptomInstant;
    }

    public void setSysptomInstant(String sysptomInstant) {
        this.sysptomInstant = sysptomInstant;
    }
}
