package com.carconnect.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String startTime;
    private String endTime;
    private String status;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private User renter;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private com.carconnect.models.Payment payment;

    // Getters, setters, constructors...
}
