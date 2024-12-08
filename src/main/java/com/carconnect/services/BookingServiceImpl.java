package com.carconnect.services;

import com.carconnect.dto.BookingDTO;
import com.carconnect.enums.BookingStatus;
import com.carconnect.mappers.BookingMapper;
import com.carconnect.dto.CarDTO;
import com.carconnect.models.Booking;
import com.carconnect.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking createBooking(Booking booking) {
        booking.setStatus(BookingStatus.PENDING); // Default status
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        if (bookingRepository.existsById(id)) {
            return bookingRepository.save(booking);
        }
        return null;
    }

    public BookingDTO updateBookingStatus(Long bookingId, BookingStatus newStatus, Long ownerId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + bookingId));

        if (!booking.getCar().getOwner().getId().equals(ownerId)) {
            throw new SecurityException("Only the owner can update the booking status.");
        }

        booking.setStatus(newStatus);
        Booking updatedBooking = bookingRepository.save(booking);
        return bookingMapper.toBookingDTO(updatedBooking, true);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<BookingDTO> getBookingsByRenter(Long renterId) {
        return bookingRepository.findByRenterId(renterId).stream()
                .map(booking -> bookingMapper.toBookingDTO(booking, false)) // Exclude renter ID
                .collect(Collectors.toList());
    }

    public List<BookingDTO> getBookingsForOwner(Long ownerId) {
        return bookingRepository.findByCarOwnerId(ownerId).stream()
                .map(booking -> bookingMapper.toBookingDTO(booking, true)) // Include renter ID
                .collect(Collectors.toList());
    }
}
