package enit.bank.service;
import javax.persistence.criteria.Review;
import enit.bank.repository.OrdersRepository;
public class reviewService {
	ReviewsRepository ReviewsRepository;
    public ReviewsService( ReviewsRepository ReviewsRepository){
        this.ReviewsRepository=ReviewsRepository;
    }

    public Reviews create(Reviews reviews) {
        //verifier le reste des fonctions
        return ReviewsRepository.insert(Reviews);
    }
}
