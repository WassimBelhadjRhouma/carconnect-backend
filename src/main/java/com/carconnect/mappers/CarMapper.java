package com.carconnect.mappers;

import com.carconnect.dto.CarDTO;
import com.carconnect.models.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDTO toCarDTO(Car car) {
        if (car == null) {
            return null;
        }

        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setOwnerId(car.getOwner().getId());

        return carDTO;
    }

    public Car toCarEntity(CarDTO carDTO) {
        if (carDTO == null) {
            return null;
        }

        Car car = new Car();
        car.setId(carDTO.getId());
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        return car;
    }
}

