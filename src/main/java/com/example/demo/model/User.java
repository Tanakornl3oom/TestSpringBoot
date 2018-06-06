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

    public void setusername(String username){
        this.username = username;
    }
    public void setlastname(String lastname){
        this.lastname = lastname;
    }
    public String getusername(){
       return username;
    }
    public String getlastname(){
        return lastname;
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

