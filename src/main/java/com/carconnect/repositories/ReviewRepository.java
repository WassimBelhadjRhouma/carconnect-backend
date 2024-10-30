package com.carconnect.repositories;

import com.carconnect.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Additional custom queries (if needed) can be added here
}
