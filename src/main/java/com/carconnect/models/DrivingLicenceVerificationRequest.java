package com.carconnect.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "driving_licence_verification_requests")
public class DrivingLicenceVerificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drivingLicenceFrontPage;
    private String drivingLicenceBackPage;
    private LocalDate submittedAt;
    private LocalDate reviewedAt;
    private String status;
    private String comment;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters, setters, constructors...
}
