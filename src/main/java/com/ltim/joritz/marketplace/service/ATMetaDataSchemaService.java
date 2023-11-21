package com.ltim.joritz.marketplace.service;

import java.util.List;
import java.util.Optional;

import com.ltim.joritz.marketplace.model.ATMetaDataSchemaModel;

public interface ATMetaDataSchemaService {

	ATMetaDataSchemaModel createATMetaDataSchema(ATMetaDataSchemaModel atMetaDataSchema);

	List<ATMetaDataSchemaModel> getATMetaData(String str);

	List<Integer> getMetaDataSchema(int artifactTypeId);

	List<ATMetaDataSchemaModel> getSchemaByArtifactTypeId(int artifactTypeId);

	Optional<ATMetaDataSchemaModel> getATMetaDataSchema(int atMetaDataSchemaId);

	List<ATMetaDataSchemaModel> getAllATMetaDataSchemas();

  
}
