package com.carconnect.dto.filters;

public class CarFilterDTO {
    private String make;
    private String model;
    private String drivingMode;
    private Double minPrice;
    private Double maxPrice;

    
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
    public String getDrivingMode() {
        return drivingMode;
    }
    public void setDrivingMode(String drivingMode) {
        this.drivingMode = drivingMode;
    }
    public Double getMinPrice() {
        return minPrice;
    }
    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }
    public Double getMaxPrice() {
        return maxPrice;
    }
    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    // Getters and setters
}