package com.esliceu.dwes.boot.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xavi on 23/02/17.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String surname;
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @OrderBy("date desc")
    private List<Fixatge> fixatges;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> roles ;

    public User(){}

    public User(String name, String surname,String username,String password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Rol> getRoles() {return roles;}

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Fixatge> getFixatges() {
        return fixatges;
    }

    public void setFixatges(List<Fixatge> fixatges) {
        this.fixatges = fixatges;
    }
}
