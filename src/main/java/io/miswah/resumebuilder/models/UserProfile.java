package io.miswah.resumebuilder.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "selected_template")
    private int selectedTemplate;

    @Column(name = "summary", length = 9999)
    private String summary;

    @Column(name="user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "current_designation")
    private String currentDesignation;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNumber;

    //Constructors
    public UserProfile() {
    }

    public UserProfile(int selectedTemplate, String summary, String userName, String firstName, String lastName, String currentDesignation, String email, String phoneNumber) {
        this.selectedTemplate = selectedTemplate;
        this.summary = summary;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentDesignation = currentDesignation;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }


    public int getSelectedTemplate() {
        return selectedTemplate;
    }

    public void setSelectedTemplate(int selectedTemplate) {
        this.selectedTemplate = selectedTemplate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCurrentDesignation() {
        return currentDesignation;
    }

    public void setCurrentDesignation(String currentDesignation) {
        this.currentDesignation = currentDesignation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
