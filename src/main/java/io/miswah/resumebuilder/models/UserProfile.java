package io.miswah.resumebuilder.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    @JoinColumn(name = "experience_id")
    List<Experience> experienceList = new ArrayList<>();

    @ElementCollection(targetClass = String.class)
    List<String> skills = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    @JoinColumn(name = "eduction_id")
    List<Education> educationList = new ArrayList<>();

    //Constructors
    public UserProfile() {
    }

    public UserProfile(int id, int selectedTemplate, String summary, String userName, String firstName, String lastName, String currentDesignation, String email, String phoneNumber, List<Experience> experienceList, List<String> skills, List<Education> educationList) {
        this.id = id;
        this.selectedTemplate = selectedTemplate;
        this.summary = summary;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentDesignation = currentDesignation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.experienceList = experienceList;
        this.skills = skills;
        this.educationList = educationList;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", selectedTemplate=" + selectedTemplate +
                ", summary='" + summary + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", currentDesignation='" + currentDesignation + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experienceList=" + experienceList +
                ", skills=" + skills +
                ", educationList=" + educationList +
                '}';
    }
}
