package com.example.InterviewManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Interviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "panel_id")
    private Users panel;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Applications applications;

    private LocalDate date;

    private LocalTime time;

    private LocalDateTime created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getPanel() {
        return panel;
    }

    public void setPanel(Users panel) {
        this.panel = panel;
    }

    public Applications getApplications() {
        return applications;
    }

    public void setApplications(Applications applications) {
        this.applications = applications;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public InterviewStatus getStatus() {
        return status;
    }

    public void setStatus(InterviewStatus status) {
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    private InterviewStatus status;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();

        if(status == null){
            status = InterviewStatus.SCHEDULED;
        }
    }
}