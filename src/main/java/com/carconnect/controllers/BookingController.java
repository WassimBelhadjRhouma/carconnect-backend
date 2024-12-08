package com.carconnect.controllers;

import com.carconnect.dto.BookingDTO;
import com.carconnect.enums.BookingStatus;
import com.carconnect.models.Booking;
import com.carconnect.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            bookingService.createBooking(booking);
            return ResponseEntity.ok(Map.of("message", "Booking successfully sent"));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{bookingId}/status")
    public ResponseEntity<BookingDTO> updateBookingStatus(
            @PathVariable Long bookingId,
            @RequestParam BookingStatus status,
            @RequestParam Long userId) {

        BookingDTO updatedBooking = bookingService.updateBookingStatus(bookingId, status, userId);
        return ResponseEntity.ok(updatedBooking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.updateBooking(id, booking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/renter/{renterId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByRenter(@PathVariable Long renterId) {
        List<BookingDTO> bookings = bookingService.getBookingsByRenter(renterId);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<BookingDTO>> getBookingsForOwner(@PathVariable Long ownerId) {
        List<BookingDTO> bookings = bookingService.getBookingsForOwner(ownerId);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Map<String, List<BookingDTO>>> getBookingsForUser(@PathVariable Long userId) {
        List<BookingDTO> renterBookings = bookingService.getBookingsByRenter(userId);
        List<BookingDTO> ownerBookings = bookingService.getBookingsForOwner(userId);

        Map<String, List<BookingDTO>> response = new HashMap<>();
        response.put("renterBookings", renterBookings);
        response.put("ownerRequests", ownerBookings);

        return ResponseEntity.ok(response);
    }

}
