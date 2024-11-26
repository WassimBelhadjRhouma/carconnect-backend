package com.carconnect.services;

import java.util.List;
import java.util.Map;

import com.carconnect.dto.projection.CarProjection;
import com.carconnect.models.Car;

public interface CarService {
    List<CarProjection> getAllCars();
    CarProjection getCarById(Long id);
    Car createCar(Car car);
    void deleteCar(Long id);
    CarProjection updateCarPartially(Long id, Map<String, Object> updates);
}
