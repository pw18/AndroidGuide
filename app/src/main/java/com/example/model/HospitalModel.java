package com.example.model;

import java.util.List;

/**
 * Created by Administrator on 5/7/2016.
 */
public class HospitalModel {

    private String title;
    private List<ProvinceModel> provinceList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProvinceModel> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceModel> provinceList) {
        this.provinceList = provinceList;
    }
}
