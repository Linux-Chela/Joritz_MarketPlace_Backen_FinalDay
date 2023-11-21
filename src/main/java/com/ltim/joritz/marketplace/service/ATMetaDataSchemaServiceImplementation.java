package com.ltim.joritz.marketplace.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.joritz.marketplace.model.ATMetaDataSchemaModel;
import com.ltim.joritz.marketplace.model.ArtifactTypeModel;
import com.ltim.joritz.marketplace.repository.ATMetaDataSchemaRepository;
import com.ltim.joritz.marketplace.repository.ArtifactTypeRepository;

@Service
public class ATMetaDataSchemaServiceImplementation implements ATMetaDataSchemaService {
	
	@Autowired
	ATMetaDataSchemaRepository atMetaDataSchemaRepository;
	@Autowired
	ArtifactTypeRepository artifactTypeRepository;
	
	@Override
	public ATMetaDataSchemaModel createATMetaDataSchema(ATMetaDataSchemaModel atMetaDataSchema) {
		System.out.println("---------"+atMetaDataSchema);
		int artifactTypeId = atMetaDataSchema.getArtifactType().getArtifactTypeId();
		Optional<ArtifactTypeModel> existingType = artifactTypeRepository.findById(artifactTypeId);
        if (existingType.isPresent()) {
        	atMetaDataSchema.setArtifactType(existingType.get());
            return atMetaDataSchemaRepository.save(atMetaDataSchema);
        } else {
            throw new RuntimeException("ArtifactType is not present for this id");
        }
    
	}
	
	@Override
	public List<ATMetaDataSchemaModel> getATMetaData(String str) {
		// TODO Auto-generated method stub
		    try {
//		        System.out.println("------------------" + artifactTypeRepository.findByArtifactName(str));

		        List<ArtifactTypeModel> artifactTypes = artifactTypeRepository.findByArtifactCategory(str);

		        if (artifactTypes != null && !artifactTypes.isEmpty()) {
		            int artifactId = artifactTypes.get(0).getArtifactTypeId();
		            System.out.println("-------");
		            System.out.println(artifactId);
		            return atMetaDataSchemaRepository.findByArtifactTypeArtifactTypeId(artifactId);
		        } else {
		            System.out.println("No artifact type found for name: " + str);
		            // You may choose to throw an exception or return an empty list based on your requirement
		            return Collections.emptyList();
		        }
		    } catch (Exception e) {
		        // Log the exception or handle it based on your requirement
		        e.printStackTrace();
		        return Collections.emptyList(); // Return an empty list or handle the error as needed
		    }
		}

	@Override
	public List<Integer> getMetaDataSchema(int artifactTypeId) {
		// TODO Auto-generated method stub
		
		
	List<ATMetaDataSchemaModel>data = atMetaDataSchemaRepository.findByArtifactTypeArtifactTypeId(artifactTypeId);
	
	List<Integer>result = new ArrayList<>() ;

	
	for(int i = 0 ;i<data.size() ;i++) {
		
		result.add(data.get(i).getAtMDSchemaId());
	}
	
		
	System.out.println(result);
	return result;
	}
	
	public Optional<ATMetaDataSchemaModel> getATMetaDataSchema(int atMetaDataSchemaId){
		return atMetaDataSchemaRepository.findById(atMetaDataSchemaId);
	}
	
	public List<ATMetaDataSchemaModel> getSchemaByArtifactTypeId(int artifactTypeId){
		return atMetaDataSchemaRepository.findByArtifactTypeArtifactTypeId(artifactTypeId);
	}


	public List<ATMetaDataSchemaModel> getAllATMetaDataSchemas(){
		return atMetaDataSchemaRepository.findAll();
	}
	
	
	
	
	

	
	

}
