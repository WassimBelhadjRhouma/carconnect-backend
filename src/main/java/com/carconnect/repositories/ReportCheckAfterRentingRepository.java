package com.carconnect.repositories;

import com.carconnect.models.ReportCheckAfterRenting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCheckAfterRentingRepository extends JpaRepository<ReportCheckAfterRenting, Long> {
    // Additional custom queries (if needed) can be added here
}
