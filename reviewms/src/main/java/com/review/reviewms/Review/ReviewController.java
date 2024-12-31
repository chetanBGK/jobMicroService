package com.review.reviewms.Review;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/review")
public class ReviewController {
    
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/addreview")
    public Review addReview(@RequestBody Review review,@RequestParam int companyId) {
        return reviewService.createReview(review,companyId);
    }

    @GetMapping("/getallreview")
    public List<Review> getAllReview(@RequestParam int companyId) {
        return reviewService.getAllReviews(companyId);
    }

    @GetMapping("getreviewbyid/{rid}")
    public Review getReviewById(@PathVariable int rid) {

        return reviewService.getReviewById(rid);
    }

    @PutMapping("updatereview/{rid}")
    public Review updateReview(@PathVariable int cid,@PathVariable int rid, @RequestBody Review review) {
        return reviewService.updateReview(rid, review);
    }

    @DeleteMapping("deletereview/{rid}")
    public void deleteReview(@PathVariable int cid,@PathVariable int rid) {
        reviewService.deleteReview(rid);
    }
    
}
