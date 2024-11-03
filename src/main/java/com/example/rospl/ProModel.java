package com.example.rospl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pro")
public class ProModel {
    @Id
    private String id;
    private String username;
    private String password;
    private String orgname;
    private String info;
    private String email;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getorg() {
        return orgname;
    }

    public void setorg(String org) {
        this.orgname = org;
    }

    public String getinfo() {
        return info;
    }

    public void setinfo(String info) {
        this.info = info;
    }

    public String getmail() {
        return email;
    }

    public void setmail(String pass) {
        this.email = pass;
    }

    public String getpass() {
        return password;
    }

    public void setpass(String pass) {
        this.password = pass;
    }
}
