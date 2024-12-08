package com.carconnect.mappers;

import com.carconnect.dto.BookingDTO;
import com.carconnect.dto.CarDTO;
import com.carconnect.models.Booking;
import com.carconnect.models.Car;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class BookingMapper {

    private final CarMapper carMapper;

    @Autowired
    public BookingMapper(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    public BookingDTO toBookingDTO(Booking booking, boolean includeRenterId) {
        if (booking == null) {
            return null;
        }

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setEndDate(booking.getEndDate());
        bookingDTO.setStatus(booking.getStatus().name());
        bookingDTO.setCar(carMapper.toCarDTO(booking.getCar()));
        bookingDTO.setRenterId(booking.getRenter().getId());

        return bookingDTO;
    }
}
