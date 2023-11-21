package com.ltim.joritz.marketplace.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltim.joritz.marketplace.model.ATMetaDataModel;

@Repository
public interface ATMetaDataRepository extends JpaRepository<ATMetaDataModel, Integer>{

	List<ATMetaDataModel> findByArtifactArtifactid(int artifactId);

	
	

}
