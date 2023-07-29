package io.miswah.resumebuilder.models;


import jakarta.persistence.*;

@Entity
@Table(name = "_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "roles")
    private String roles;

    @Column(name="email", unique = true)
    private String email;


    //Constructors
    public User() {
    }

    public User(String userName, String password, boolean active, String roles, String email) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.email = email;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
