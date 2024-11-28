package com.carconnect.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carconnect.dto.filters.CarFilterDTO;
import com.carconnect.dto.projection.CarProjection;
import com.carconnect.models.Car;
import com.carconnect.services.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/filter")
    public ResponseEntity<List<CarProjection>> getFilteredCars(@RequestBody CarFilterDTO filter) {
        return ResponseEntity.ok(carService.getFilteredCars(filter.getMake(),filter.getFuelType(), filter.getModel(), filter.getDrivingMode(),filter.getMinPrice(), filter.getMaxPrice()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarProjection> getCarById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.createCar(car));
    }

    @PatchMapping("/{id}")
public ResponseEntity<CarProjection> updateCarPartially(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
    CarProjection updatedCar = carService.updateCarPartially(id, updates);
    return ResponseEntity.ok(updatedCar);
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
