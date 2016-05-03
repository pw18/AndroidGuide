package com.example.model;

/**
 * Created by Administrator on 5/2/2016.
 */
public class PhamaceuticalModel {
    private int id;
    private String name;
    private String parallel;
    private String details;

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParallel() {return parallel; }

    public void setParallel(String parallel){this.parallel = parallel;}

    public String getDetails() {return details; }

    public void setDetails(String details) {this.details = details;}

}
