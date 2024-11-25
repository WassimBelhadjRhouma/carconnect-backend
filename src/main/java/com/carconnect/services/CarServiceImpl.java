package com.carconnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carconnect.dto.projection.CarProjection;
import com.carconnect.models.Car;
import com.carconnect.repositories.CarRepository;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarProjection> getAllCars() {
        return carRepository.findAllProjectedBy();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        if (carRepository.existsById(id)) {
            return carRepository.save(car);
        }
        return null;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
