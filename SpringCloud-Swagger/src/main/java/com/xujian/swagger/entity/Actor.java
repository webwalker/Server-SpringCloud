package com.xujian.swagger.entity;

public class Actor {

    private Recipt recipt;

    private String address;
    private Integer sort;

    private DeepOne deepOne;

    public DeepOne getDeepOne() {
        return deepOne;
    }

    public void setDeepOne(DeepOne deepOne) {
        this.deepOne = deepOne;
    }

    public Recipt getRecipt() {
        return recipt;
    }

    public void setRecipt(Recipt recipt) {
        this.recipt = recipt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
