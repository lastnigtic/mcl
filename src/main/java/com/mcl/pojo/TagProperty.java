package com.mcl.pojo;

public class TagProperty {
    private Integer id;

    private String type;

    private String name;

    private String icon ;

    private Integer iconorder ;

    public Integer getIconorder() {
        return iconorder;
    }

    public void setIconorder(Integer iconorder) {
        this.iconorder = iconorder;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }



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