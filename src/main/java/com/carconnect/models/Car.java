package com.carconnect.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String streetAddress;
    private String city;
    private String drivingMode;
    private Number postalCode;
    private String description;
    private String make;
    private String model;
    private int year;
    private String fuelType;
    private String licencePlate;
    private String mileage;
    private double pricePerDay;


    // the availability will be considered when the booking functionnality is implemented
    // private String availability;
    // location to be updated
    // private String location;

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

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title=title;
    }

    public String getDrivingMode() {
        return drivingMode;
    }
    public void setDrivingMode(String drivingMode) {
        this.drivingMode=drivingMode;
    }


    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress=streetAddress;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city=city;
    }

    public Number getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(Number postalCode) {
        this.postalCode=postalCode;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
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

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    // public String getAvailability() {
    //     return availability;
    // }

    // public void setAvailability(String availability) {
    //     this.availability = availability;
    // }

    // public String getLocation() {
    //     return location;
    // }

    // public void setLocation(String location) {
    //     this.location = location;
    // }

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
