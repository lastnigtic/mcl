package com.mcl.pojo;

public class Admin {
    private String id;

    private String pass;

    public Admin(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public Admin() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }
}