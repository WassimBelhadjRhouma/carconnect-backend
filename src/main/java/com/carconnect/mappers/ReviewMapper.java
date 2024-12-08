package com.carconnect.mappers;

import com.carconnect.dto.ReviewDTO;
import com.carconnect.models.Car;
import com.carconnect.models.Review;
import com.carconnect.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReviewMapper {

    public ReviewDTO toReviewDTO(Review review) {
        if (review == null) {
            return null;
        }

        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setSubmittedAt(review.getSubmittedAt());
        reviewDTO.setUserId(review.getUser().getId());
        reviewDTO.setCarId(review.getCar().getId());
        return reviewDTO;
    }

    public Review toReviewEntity(ReviewDTO reviewDTO, User user, Car car) {
        if (reviewDTO == null) {
            return null;
        }

        Review review = new Review();
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        review.setSubmittedAt(LocalDate.now());
        review.setUser(user);
        review.setCar(car);
        return review;
    }
}

