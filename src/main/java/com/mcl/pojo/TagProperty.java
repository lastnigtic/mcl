package com.mcl.pojo;

public class TagProperty {
    private Integer id;

    private String type;

    private String name;

    public TagProperty(Integer id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public TagProperty() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}