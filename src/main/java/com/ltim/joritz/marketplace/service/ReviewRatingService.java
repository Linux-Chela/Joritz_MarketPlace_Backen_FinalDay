package com.ltim.joritz.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.joritz.marketplace.model.ReviewRatingModel;
import com.ltim.joritz.marketplace.repository.ReviewRatingRepository;

@Service
public class ReviewRatingService {
	
	@Autowired
	public ReviewRatingRepository reviewRatingRepository;
	
	public ReviewRatingModel createReviewRating(ReviewRatingModel reviewRating) {
		return reviewRatingRepository.save(reviewRating);
	}
	
	public List<ReviewRatingModel> getAllReviewRating(){
		System.out.println("Displaying All Reviews and Ratings...");
		return reviewRatingRepository.findAll();
	}
	
	public List<ReviewRatingModel> getReviewRatingByArtifactId(int artifactId){
		System.out.println("Displaying Review and Ratings for Single Artifact...");
		return reviewRatingRepository.findByArtifactArtifactid(artifactId);
	}
	public Optional<Double> getAverageRatingByArtifactId(int artifactId) {
        System.out.println("Fetching Average Rating for Artifact ID: " + artifactId);
        return reviewRatingRepository.getAverageRatingByArtifactId(artifactId);
    }
	


}
