package com.carconnect.repositories;

import com.carconnect.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Additional custom queries (if needed) can be added here
}
