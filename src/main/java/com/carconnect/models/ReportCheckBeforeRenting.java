package com.carconnect.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "report_checks_before_renting")
public class ReportCheckBeforeRenting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carConditionReport;
    private String photos;
    private String ownerReviewStatus;
    private String ownerComment;
    private LocalDate submittedAt;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // Getters, setters, constructors...
}
