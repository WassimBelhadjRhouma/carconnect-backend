package com.carconnect.services;

import com.carconnect.dto.BookingDTO;
import com.carconnect.enums.BookingStatus;
import com.carconnect.models.Booking;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    Booking createBooking(Booking booking);
    Booking updateBooking(Long id, Booking booking);
    void deleteBooking(Long id);
    List<BookingDTO> getBookingsByRenter(Long renterId);
    List<BookingDTO> getBookingsForOwner(Long ownerId);
    BookingDTO updateBookingStatus(Long bookingId, BookingStatus status, Long ownerId);
}
