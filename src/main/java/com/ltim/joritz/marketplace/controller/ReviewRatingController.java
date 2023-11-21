package com.ltim.joritz.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltim.joritz.marketplace.model.ReviewRatingModel;
import com.ltim.joritz.marketplace.service.ReviewRatingService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/service/0/marketplace/reviewrating")
public class ReviewRatingController {
	
	@Autowired
	ReviewRatingService reviewRatingService;
	
	
	@PostMapping("create")
	public ReviewRatingModel createReviewRating(@RequestBody ReviewRatingModel reviewRating) {
		System.out.println("Creating Review and Rating...");
		return reviewRatingService.createReviewRating(reviewRating);
	}
	
	@GetMapping("getall")
	public List<ReviewRatingModel> getAllReviewRating(){
		System.out.println("Displaying All Reviews and Ratings");
		return reviewRatingService.getAllReviewRating();
	}
	
	@GetMapping("getbyartifactid/{artifactId}")
	public List<ReviewRatingModel> getReviewRating(@PathVariable int artifactId){
		System.out.println("Displaying Review and Rating for single Artifact");
		return reviewRatingService.getReviewRatingByArtifactId(artifactId);
	}
	
	@GetMapping("getaverageratingbyartifactid/{artifactId}")
    public Optional<Double> getAverageRatingByArtifactId(@RequestParam int artifactId) {
        return reviewRatingService.getAverageRatingByArtifactId(artifactId);
    }


}
