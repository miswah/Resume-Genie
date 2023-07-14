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

    @Column(name = "summary")
    private String summary;

    //Constructors
    public UserProfile() {
    }

    public UserProfile(int selectedTemplate, String summary) {
        this.selectedTemplate = selectedTemplate;
        this.summary = summary;
    }

    //Getters and setters

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
}
