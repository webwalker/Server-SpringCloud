package com.xujian.swagger.entity;

import java.util.List;

public class Recipt {

    private String name;
    private String id;

    private List<Actor> actors;

    private EnumDomain enumDomain;

    public EnumDomain getEnumDomain() {
        return enumDomain;
    }

    public void setEnumDomain(EnumDomain enumDomain) {
        this.enumDomain = enumDomain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
