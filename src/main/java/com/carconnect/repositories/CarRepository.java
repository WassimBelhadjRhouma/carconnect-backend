package com.carconnect.repositories;

import com.carconnect.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    // Additional custom queries (if needed) can be added here
}
