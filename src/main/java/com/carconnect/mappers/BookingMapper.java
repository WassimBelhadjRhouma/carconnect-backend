package com.carconnect.mappers;

import com.carconnect.dto.BookingDTO;
import com.carconnect.dto.CarDTO;
import com.carconnect.models.Booking;
import com.carconnect.models.Car;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingDTO toBookingDTO(Booking booking, boolean includeRenterId) {
        if (booking == null) {
            return null;
        }

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setEndDate(booking.getEndDate());
        bookingDTO.setStatus(booking.getStatus().name());
        bookingDTO.setCar(toCarDTO(booking.getCar()));
        bookingDTO.setRenterId(booking.getRenter().getId());

        return bookingDTO;
    }

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
}
