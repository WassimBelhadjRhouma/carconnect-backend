package com.carconnect.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "report_checks_after_renting")
public class ReportCheckAfterRenting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carConditionReport;
    private String photos;
    private String renterReviewStatus;
    private String renterComment;
    private LocalDate submittedAt;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private User renter;

    // Getters, setters, constructors...
}
