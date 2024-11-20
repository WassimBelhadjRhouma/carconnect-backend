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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public ReportCheckBeforeRenting getReportCheckBefore() {
        return reportCheckBefore;
    }

    public void setReportCheckBefore(ReportCheckBeforeRenting reportCheckBefore) {
        this.reportCheckBefore = reportCheckBefore;
    }

    public ReportCheckAfterRenting getReportCheckAfter() {
        return reportCheckAfter;
    }

    public void setReportCheckAfter(ReportCheckAfterRenting reportCheckAfter) {
        this.reportCheckAfter = reportCheckAfter;
    }
}
