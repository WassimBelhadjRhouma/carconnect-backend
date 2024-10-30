package com.carconnect.repositories;

import com.carconnect.models.DrivingLicenceVerificationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingLicenceVerificationRequestRepository extends JpaRepository<DrivingLicenceVerificationRequest, Long> {
    // Additional custom queries (if needed) can be added here
}
