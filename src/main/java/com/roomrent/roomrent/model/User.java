package com.roomrent.roomrent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int Id;

    private String name;

    private String city;

    private String status;

    public User(int id, String name, String city, String status) {
        Id = id;
        this.name = name;
        this.city = city;
        this.status = status;
    }

    public User() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserController [Id=" + Id + ", city=" + city + ", name=" + name + ", status=" + status + "]";
    }
    
    
}
