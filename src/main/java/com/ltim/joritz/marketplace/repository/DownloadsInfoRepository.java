package com.ltim.joritz.marketplace.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltim.joritz.marketplace.model.DownloadsInformation;

public interface DownloadsInfoRepository extends JpaRepository<DownloadsInformation, Integer>{

	
	
//	@Query("SELECT a.ArtifactType.artifactTypeName, COUNT(d.*) "
//			+ "FROM downloadsinfo d JOIN d.artifactid a "
//			+"GROUP BY a.ArtifactType.artifactTypeName")
//	List<Object[]> getDownloadsInfoGroupedByArtifactCategory();
	
    @Query("SELECT a.artifactType.artifactCategory, COUNT(d) " +
            "FROM DownloadsInformation d " +
            "INNER JOIN d.artifactModel a " +
            "GROUP BY a.artifactType.artifactCategory")
     List<Object[]> countAllByArtifactModel_ArtifactType();
     
     @Query("SELECT " +
             "SUM(CASE WHEN d.isUserPublic = true THEN 1 ELSE 0 END) AS trueCount, " +
             "SUM(CASE WHEN d.isUserPublic = false THEN 1 ELSE 0 END) AS falseCount " +
             "FROM DownloadsInformation d")
      Map<Boolean, Long> countByIsUserPublic();
     
     @Query("SELECT COUNT(d) " +
             "FROM DownloadsInformation d " +
             "JOIN d.artifactModel a " +
             "WHERE a.isPublic = ?1")
      Long countByArtifactModel_IsPublic(boolean isPublic);
     
}

