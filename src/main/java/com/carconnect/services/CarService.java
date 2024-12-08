package com.carconnect.services;

import java.util.List;
import java.util.Map;

import com.carconnect.dto.projection.CarProjection;
import com.carconnect.models.Car;

public interface CarService {
    List<CarProjection> getFilteredCars(String make,String FuelType, String model, String drivingMode, Double minPrice, Double maxPrice);
    CarProjection getCarById(Long id);
    Car createCar(Car car);
    void deleteCar(Long carId, Long ownerId);
    CarProjection updateCarPartially(Long id, Map<String, Object> updates);
    List<Car> getCarsByUserId(Long userId);
    Car updateCar(Long carId, Car updatedCar, Long ownerId);
}
