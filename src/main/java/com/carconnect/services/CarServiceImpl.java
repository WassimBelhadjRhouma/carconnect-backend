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

    @Override
    public CarProjection getCarById(Long id) {
        return carRepository.findCarById(id);
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }


    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
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
}
