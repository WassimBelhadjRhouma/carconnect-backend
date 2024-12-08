package com.carconnect.repositories;

import com.carconnect.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRenterId(Long renterId);

    @Query("SELECT b FROM Booking b WHERE b.car.owner.id = :ownerId")
    List<Booking> findByCarOwnerId(@Param("ownerId") Long ownerId);
}
