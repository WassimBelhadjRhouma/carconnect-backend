package com.carconnect.controllers;

import com.carconnect.dto.ReviewDTO;
import com.carconnect.mappers.ReviewMapper;
import com.carconnect.models.Review;
import com.carconnect.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody Review review) {
        try {
            reviewService.createReview(review);
            return ResponseEntity.ok(Map.of("message", "Review created successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<ReviewDTO>> getAllReviewsByCarId(@PathVariable Long carId) {
        List<Review> reviews = reviewService.getAllReviewsByCarId(carId);
        List<ReviewDTO> reviewDTOs = reviews.stream()
                .map(reviewMapper::toReviewDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviewDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        return ResponseEntity.ok(reviewService.updateReview(id, review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
