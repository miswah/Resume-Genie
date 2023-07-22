package io.miswah.resumebuilder.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "company")
    private String company;

    @Column(name = "designation")
    private String designation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "details", length = 655)
    private String details;

    @Column(name = "is_current_job")
    private Boolean isCurrentJob;

    public Experience() {
    }

    public Experience(int id, String company, String designation, LocalDate startDate, LocalDate endDate, String details, Boolean isCurrentJob) {
        this.id = id;
        this.company = company;
        this.designation = designation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.details = details;
        this.isCurrentJob = isCurrentJob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getIsCurrentJob() {
        return isCurrentJob;
    }

    public void setCurrentJob(Boolean currentJob) {
        isCurrentJob = currentJob;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", designation='" + designation + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", details='" + details + '\'' +
                ", isCurrentJob=" + isCurrentJob +
                '}';
    }
}
