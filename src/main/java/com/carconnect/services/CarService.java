package com.carconnect.services;

import java.util.List;

import com.carconnect.dto.projection.CarProjection;
import com.carconnect.models.Car;

public interface CarService {
    List<CarProjection> getAllCars();
    Car getCarById(Long id);
    Car createCar(Car car);
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
}
