package com.esliceu.dwes.boot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by blackwidow on 2/03/17.
 */
@Entity
public class  Rol implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String rolName;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users;

    public Rol(){}

    public Rol(String role_name,String desc){
        this.rolName = role_name;
        this.description = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return rolName;
    }

    public void setRole_name(String role_name) {
        this.rolName = role_name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public List<User> getUsers() {return users;}

    public void setUsers(List<User> users) {this.users = users;}
}
