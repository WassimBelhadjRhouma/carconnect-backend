package com.carconnect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    @Column(unique = true)
    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    private LocalDate birthDate;

    private String role;

    private String status;

    private LocalDate createdAt;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Car> cars;

    @OneToMany(mappedBy = "renter", cascade = CascadeType.ALL)
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Review> reviews;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private com.carconnect.models.DrivingLicenceVerificationRequest drivingLicenceVerification;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private com.carconnect.models.CarOwnershipVerificationRequest carOwnershipVerification;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<ReportCheckBeforeRenting> reportChecksBeforeRenting;

    @OneToMany(mappedBy = "renter", cascade = CascadeType.ALL)
    private Set<ReportCheckAfterRenting> reportChecksAfterRenting;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
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

    public DrivingLicenceVerificationRequest getDrivingLicenceVerification() {
        return drivingLicenceVerification;
    }

    public void setDrivingLicenceVerification(DrivingLicenceVerificationRequest drivingLicenceVerification) {
        this.drivingLicenceVerification = drivingLicenceVerification;
    }

    public CarOwnershipVerificationRequest getCarOwnershipVerification() {
        return carOwnershipVerification;
    }

    public void setCarOwnershipVerification(CarOwnershipVerificationRequest carOwnershipVerification) {
        this.carOwnershipVerification = carOwnershipVerification;
    }

    public Set<ReportCheckBeforeRenting> getReportChecksBeforeRenting() {
        return reportChecksBeforeRenting;
    }

    public void setReportChecksBeforeRenting(Set<ReportCheckBeforeRenting> reportChecksBeforeRenting) {
        this.reportChecksBeforeRenting = reportChecksBeforeRenting;
    }

    public Set<ReportCheckAfterRenting> getReportChecksAfterRenting() {
        return reportChecksAfterRenting;
    }

    public void setReportChecksAfterRenting(Set<ReportCheckAfterRenting> reportChecksAfterRenting) {
        this.reportChecksAfterRenting = reportChecksAfterRenting;
    }
}
