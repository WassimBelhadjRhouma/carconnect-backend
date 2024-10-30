package com.carconnect.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private int year;
    private String licencePlate;
    private int mileage;
    private double pricePerDay;
    private String availability;
    private String location;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Review> reviews;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private ReportCheckBeforeRenting reportCheckBefore;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private ReportCheckAfterRenting reportCheckAfter;

    // Getters, setters, constructors...
}
