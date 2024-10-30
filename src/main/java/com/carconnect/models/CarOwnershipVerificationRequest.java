package com.carconnect.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "car_ownership_verification_requests")
public class CarOwnershipVerificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registrationDocument;
    private String comment;
    private LocalDate submittedAt;
    private LocalDate reviewedAt;
    private String status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters, setters, constructors...
}
