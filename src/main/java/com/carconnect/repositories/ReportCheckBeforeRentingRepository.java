package com.carconnect.repositories;

import com.carconnect.models.ReportCheckBeforeRenting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCheckBeforeRentingRepository extends JpaRepository<ReportCheckBeforeRenting, Long> {
    // Additional custom queries (if needed) can be added here
}
