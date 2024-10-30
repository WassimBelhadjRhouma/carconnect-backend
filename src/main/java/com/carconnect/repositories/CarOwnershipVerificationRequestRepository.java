package com.carconnect.repositories;

import com.carconnect.models.CarOwnershipVerificationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOwnershipVerificationRequestRepository extends JpaRepository<CarOwnershipVerificationRequest, Long> {
    // Additional custom queries (if needed) can be added here
}
