package com.review.reviewms.Review.ReviewImpl;

import java.util.List;
import java.util.Objects;

import com.review.reviewms.Review.Review;
import com.review.reviewms.Review.ReviewImpl.external.Company;
import com.review.reviewms.Review.ReviewRepo;
import com.review.reviewms.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ReviewImpl implements ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

 
    @Override
    public Review createReview(Review review, int companyId) {
        if (companyId == 0) {
            throw new RuntimeException("Company not found");
            
        }
        review.setCompanyId(companyId);
        return reviewRepo.save(review);
    }

    @Override
    public Review getReviewById(int rid) {
        RestTemplate restTemplate = new RestTemplate();
        Company company= restTemplate.getForObject("http://localhost:8081/company/getcompanybyid/2", Company.class);

        System.out.println(company.getName());
        System.out.println(company.getId());
        return reviewRepo.findById(rid).get();

    }

    @Override
    public Review updateReview(int rid, Review review) {
        Review reviews= reviewRepo.findById(rid).get();

        reviews.setTitle(review.getTitle());
        reviews.setDescription(review.getDescription());
        reviews.setRating(review.getRating());
        return reviewRepo.save(reviews);

    }

    @Override
    public String deleteReview(int rid) {

        reviewRepo.deleteById(rid);
        return "Review deleted";

    }

    @Override
    public List<Review> getAllReviews(int companyId) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews;
    }
    
}
