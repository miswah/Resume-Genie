package io.miswah.resumebuilder.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "eduction")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "qualification")
    private String qualification;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "description")
    private String description;


    public Education() {
    }

    public Education(int id, String collegeName, String qualification, LocalDate startDate, LocalDate endDate, String description) {
        this.id = id;
        this.collegeName = collegeName;
        this.qualification = qualification;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", collegeName='" + collegeName + '\'' +
                ", qualification='" + qualification + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Education education)) return false;
        return getId() == education.getId() && Objects.equals(getCollegeName(), education.getCollegeName()) && Objects.equals(getQualification(), education.getQualification()) && Objects.equals(getStartDate(), education.getStartDate()) && Objects.equals(getEndDate(), education.getEndDate()) && Objects.equals(getDescription(), education.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCollegeName(), getQualification(), getStartDate(), getEndDate(), getDescription());
    }
}
