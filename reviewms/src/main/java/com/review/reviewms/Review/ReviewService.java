package com.review.reviewms.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review, int companyId);
    Review getReviewById(int rid);
    Review updateReview( int rid,Review review);
    String deleteReview( int rid);
    List<Review> getAllReviews(int companyId);
    
}
