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
import org.springframework.web.bind.annotation.RestController;

import com.ltim.joritz.marketplace.model.ATMetaDataModel;
import com.ltim.joritz.marketplace.service.ATMetaDataService;
import com.ltim.joritz.marketplace.service.ArtifactTypeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/service/0/marketplace/atmetadata")
public class ATMetaDataController {

	@Autowired
	ATMetaDataService atMetaDataService;
	
	@Autowired
	ArtifactTypeService artifactTypeService;
	
	
	@PostMapping("create")
	public ATMetaDataModel createATMetaData(@RequestBody ATMetaDataModel atMetaData) {
		return atMetaDataService.createATMetaData(atMetaData);
	}
	@GetMapping("getall")
	public List<ATMetaDataModel> getAllATMetaData(){
		return atMetaDataService.getAllATMetaData();
	}

	
	@GetMapping("getbyid/{atMetaDataId}")
	public Optional<ATMetaDataModel> getATMetaData(@PathVariable int atMetaDataId){
		return atMetaDataService.getATMetaData(atMetaDataId);
	}
	
	@GetMapping("getbyartifactid/{artifactId}")
	public List<ATMetaDataModel> getMetaDataByArtifactId(@PathVariable int artifactId){
	return atMetaDataService.getMetaDataByArtifactId(artifactId);
	}

}
