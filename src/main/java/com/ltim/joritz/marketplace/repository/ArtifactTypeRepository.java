package com.ltim.joritz.marketplace.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltim.joritz.marketplace.model.ArtifactTypeModel;

@Repository
public interface ArtifactTypeRepository extends JpaRepository<ArtifactTypeModel	, Integer>{

	List<ArtifactTypeModel> findByArtifactCategory(String str);

}
