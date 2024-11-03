// src/main/java/com/example/demo/model/FileDocument.java
package com.example.rospl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "application")
public class Modell {
    @Id
    private String id;
    private String name;
    private String course;
    private String email;
    private String oppId; // Link to the scholarship opportunity
    private String studid; // Link to the scholarship opportunity
    private String contact;
    private byte[] adhar;
    private byte[] income;
    private byte[] marksheet;
    private byte[] college_id;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getopId() {
        return oppId;
    }

    public void setopId(String oppId) {
        this.oppId = oppId;
    }

    public String getstudid() {
        return studid;
    }

    public void setstudid(String studid) {
        this.studid = studid;
    }

    public byte[] getAdhar() {
        return adhar;
    }

    public void setAdhar(byte[] content) {
        this.adhar = content;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
       this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
     }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public byte[] getIncome() {
        return income;
    }

    public void setIncome(byte[] content) {
        this.income = content;
    }

    public byte[] getMark() {
        return marksheet;
    }

    public void setMark(byte[] content) {
        this.marksheet = content;
    }

    public byte[] getCollege() {
        return college_id;
    }

    public void setCollege(byte[] content) {
        this.college_id = content;
    }
}
