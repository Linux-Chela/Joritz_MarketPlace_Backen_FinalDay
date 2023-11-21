package com.ltim.joritz.marketplace.service;

import java.util.List;
import java.util.Optional;

import com.ltim.joritz.marketplace.model.ATMetaDataModel;

public interface ATMetaDataService {
	ATMetaDataModel createATMetaData(ATMetaDataModel atMetaData);

//	ATMetaDataModel createAtMetaDataModel(ATMetaDataModel values);

//	ATMetaDataModel createAtMetaDataModel(ATMetaData atMetaData, ATMetaDataSchema atMetaDataSchema);
	List<ATMetaDataModel> getAllATMetaData();
	Optional<ATMetaDataModel> getATMetaData(int atMetaDataId);
	List<ATMetaDataModel> getMetaDataByArtifactId(int artifactId);

}
