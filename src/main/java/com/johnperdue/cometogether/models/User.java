package com.johnperdue.cometogether.models;

import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;
import java.util.Locale;

// @Entity
public class User {

    //@Id
    //@GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=20)
    private String username;

    @NotNull
    @Size(min=3, max=20)
    private String password;

    @NotNull
    @Size(min=8, max=50)
    private String orgName;

    @NotNull
    @Email
    private String email;

    @Size(min=1, max=25)
    private String manager;

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }
}