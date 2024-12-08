package com.carconnect.services;

import java.util.List;
import java.util.Map;

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
    public List<CarProjection> getFilteredCars(String make,String fuelType, String model, String drivingMode, Double minPrice, Double maxPrice) {
         return carRepository.findCarsWithFilters(make,fuelType, model, drivingMode, minPrice, maxPrice);
    }

    public List<Car> getAllCarsByUserId(Long userId) {
        return carRepository.findByOwnerId(userId);
    }

    @Override
    public CarProjection getCarById(Long id) {
        return carRepository.findCarById(id);
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getCarsByUserId(Long userId) {
        return carRepository.findByOwnerId(userId);
    }

    @Override
    public void deleteCar(Long carId, Long ownerId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Car not found with ID: " + carId));

        if (!car.getOwner().getId().equals(ownerId)) {
            throw new SecurityException("Only the owner can delete this car.");
        }

        carRepository.delete(car);
    }

    @Override
    public CarProjection updateCarPartially(Long id, Map<String, Object> updates) {
        Car car = carRepository.findById(id)
                .orElseThrow();

        updates.forEach((key, value) -> {
            switch (key) {
                case "pricePerDay":
                    car.setPricePerDay(Double.valueOf(value.toString()));
                    break;
                case "title":
                    car.setTitle((String) value);
                    break;
                case "description":
                    car.setDescription((String) value);
                    break;
                case "make":
                    car.setMake((String) value);
                    break;
                case "model":
                    car.setModel((String) value);
                    break;
                case "year":
                    car.setYear((int) value);
                    break;
                case "postalCode":
                    car.setPostalCode((int) value);
                    break;
                case "streetAddress":
                    car.setStreetAddress((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field " + key + " is not valid for update");
            }
        });

        carRepository.save(car);
        return carRepository.findCarById(id);
    }

    public Car updateCar(Long carId, Car updatedCar, Long ownerId) {
        Car existingCar = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Car not found with ID: " + carId));

        if (!existingCar.getOwner().getId().equals(ownerId)) {
            throw new SecurityException("Only the owner can update this car.");
        }

        existingCar.setMake(updatedCar.getMake());
        existingCar.setModel(updatedCar.getModel());
        //TODO: add all changeable details

        return carRepository.save(existingCar);
    }

}
