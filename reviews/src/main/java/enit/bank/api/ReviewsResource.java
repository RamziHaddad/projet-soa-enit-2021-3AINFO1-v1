package enit.bank.api;
import javax.ws.rs.POST;
import enit.bank.domain.Review;
import enit.bank.service.ReviewService;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/Reviews")
public class ReviewsResource {

	private ReviewService reviewService;
    public ReviewResource(ReviewService service) {
        this.reviewService = service;
    }
    @POST
    @Path("/create")
    public Review createReview(Review review) {
        return reviewService.create(review);
    }
}
