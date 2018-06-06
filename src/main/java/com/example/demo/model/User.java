package com.example.demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="username")
    private String username;

    @Column(name ="lastname")
    private String lastname;

    protected User() {
    }

    public User(String username, String lastname) {
        this.username = username;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return String.format("id : "+id+" ,Username : "+username+", lastname : "+lastname);
    }
}

