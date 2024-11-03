// src/main/java/com/example/demo/model/FileDocument.java
package com.example.rospl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Student {
    @Id
    private String id;
    private String username;
    private String password; // Consider storing a hashed password
    
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

    public String getpass() {
        return password;
    }

    public void setpass(String pass) {
        this.password = pass;
    }
}
