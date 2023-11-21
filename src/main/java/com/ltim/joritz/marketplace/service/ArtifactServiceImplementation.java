package com.ltim.joritz.marketplace.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.joritz.marketplace.model.ArtifactModel;
import com.ltim.joritz.marketplace.model.ArtifactTypeModel;
import com.ltim.joritz.marketplace.repository.ArtifactRepository;
import com.ltim.joritz.marketplace.repository.ArtifactTypeRepository;

@Service
public class ArtifactServiceImplementation implements ArtifactService{
	@Autowired
	private ArtifactRepository artifactRepository;
	
	@Autowired
	private ArtifactTypeRepository artifactTypeRepository;
	
	
	
	@Override
	public ArtifactModel createArtifact(ArtifactModel artifact) {
		
		 	int artifactTypeId = artifact.getArtifactType().getArtifactTypeId();
	        Optional<ArtifactTypeModel> existingType = artifactTypeRepository.findById(artifactTypeId);
	        if (existingType.isPresent()) {
	            artifact.setArtifactType(existingType.get());
	            
	            return artifactRepository.save(artifact);
	        } else {
	            throw new RuntimeException("ArtifactType is not present for this id");
	        }
	    }
	
	
	
	public List<ArtifactModel> getAllArtifacts(){
		return artifactRepository.findAll();
	
	}

	
	
	public Optional<ArtifactModel> getArtifact(int artifactId) {
		return artifactRepository.findById(artifactId);
	}
	

    public boolean isValidArtifact(ArtifactModel artifact) {
        // Example: Check if the artifact exists based on its ID
        int artifactId = artifact.getArtifactid();
        ArtifactModel foundArtifact = artifactRepository.findById(artifactId).orElse(null);

        return foundArtifact != null; // Return true if the artifact exists, false otherwise
    }


}