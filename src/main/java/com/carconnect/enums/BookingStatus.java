package com.carconnect.enums;

public enum BookingStatus {
    PENDING("Pending approval"),
    ACCEPTED("Booking accepted"),
    REFUSED("Booking refused"),
    CANCELLED("Booking cancelled");

    private final String description;

    BookingStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
