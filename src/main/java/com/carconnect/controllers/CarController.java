package com.carconnect.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.carconnect.dto.CarDTO;
import com.carconnect.mappers.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carconnect.dto.filters.CarFilterDTO;
import com.carconnect.dto.projection.CarProjection;
import com.carconnect.models.Car;
import com.carconnect.services.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @Autowired
    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping("/filter")
    public ResponseEntity<List<CarProjection>> getFilteredCars(@RequestBody CarFilterDTO filter) {
        return ResponseEntity.ok(carService.getFilteredCars(filter.getMake(),filter.getFuelType(), filter.getModel(), filter.getDrivingMode(),filter.getMinPrice(), filter.getMaxPrice()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarProjection> getCarById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CarDTO>> getCarsByUserId(@PathVariable Long userId) {
        List<Car> cars = carService.getCarsByUserId(userId);
        List<CarDTO> carDTOs = cars.stream()
                .map(carMapper::toCarDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(carDTOs);
    }

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        try {
            carService.createCar(car);
            return ResponseEntity.ok(Map.of("message", "Car created successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CarProjection> updateCarPartially(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        CarProjection updatedCar = carService.updateCarPartially(id, updates);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId, @RequestParam Long userId) {
        carService.deleteCar(carId, userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{carId}")
    public ResponseEntity<CarDTO> updateCar(
            @PathVariable Long carId,
            @RequestBody CarDTO updatedCarDTO,
            @RequestParam Long userId) {
        Car updatedCar = carService.updateCar(carId, carMapper.toCarEntity(updatedCarDTO), userId);
        return ResponseEntity.ok(carMapper.toCarDTO(updatedCar));
    }

}
