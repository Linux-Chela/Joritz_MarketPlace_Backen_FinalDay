package com.ltim.joritz.marketplace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ltim.joritz.marketplace.model.ReviewRatingModel;

@Repository
public interface ReviewRatingRepository extends JpaRepository<ReviewRatingModel, Integer>{

	
	@Query("SELECT AVG(r.rating) FROM ReviewRatingModel r WHERE r.artifact.id = :artifactId")
    Optional<Double> getAverageRatingByArtifactId(int artifactId);


	List<ReviewRatingModel> findByArtifactArtifactid(int artifactId);

}
