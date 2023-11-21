package com.ltim.joritz.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.joritz.marketplace.model.ATMetaDataModel;
import com.ltim.joritz.marketplace.model.ATMetaDataSchemaModel;
import com.ltim.joritz.marketplace.repository.ATMetaDataRepository;
import com.ltim.joritz.marketplace.repository.ATMetaDataSchemaRepository;


@Service
public class ATMetaDataServiceImplementation implements ATMetaDataService {
	
	@Autowired
	private ATMetaDataRepository atMetaDataRepository;
	
	@Autowired
	private ATMetaDataSchemaRepository atMetaDataSchemaRepository;
	
	@Override
	public ATMetaDataModel createATMetaData(ATMetaDataModel atMetaData) {
		int atMetaDataSchemaId = atMetaData.getAtMetaDataSchemaModel().getAtMDSchemaId();
		System.out.println("Creating ATMetaDataModel...");
		
		Optional<ATMetaDataSchemaModel> existingType = atMetaDataSchemaRepository.findById(atMetaDataSchemaId);
		
		if (existingType.isPresent()) {
			
            // If exists, set the ATMetaDataSchema and save ATMetaData
            atMetaData.setAtMetaDataSchemaModel(existingType.get());
            return atMetaDataRepository.save(atMetaData);
        } else {
            throw new RuntimeException("ATMetaDataSchema is not present for this ID");
        }
	}

	public List<ATMetaDataModel> getAllATMetaData(){
		return atMetaDataRepository.findAll();
	}
	
	public Optional<ATMetaDataModel> getATMetaData(int atMetaDataId){
		return atMetaDataRepository.findById(atMetaDataId);
	}
	
	public List<ATMetaDataModel> getMetaDataByArtifactId(int artifactId){
		return atMetaDataRepository.findByArtifactArtifactid(artifactId);
	}
	
	}
	
	
	

	
	
	


