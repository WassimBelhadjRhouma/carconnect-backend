
package com.carconnect.dto.projection;

public interface CarProjection{
    String getTitle();
    User getOwner();
    Long getId();
    String getDrivingMode();
    String getStreetAddress();
    String getCity();
    Number getPostalCode();
    String getDescription();
    String getFuelType();
    String getMake();
    String getModel();
    int getYear();
    String getLicencePlate();
    String getMileage();
    double getPricePerDay();
    interface User{
        Long getId();
    }
}