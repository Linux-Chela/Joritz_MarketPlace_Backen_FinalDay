package com.ltim.joritz.marketplace.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.joritz.marketplace.model.DownloadsInformation;
import com.ltim.joritz.marketplace.repository.DownloadsInfoRepository;

@Service
public class DownloadInfoService {
    
    @Autowired
    private DownloadsInfoRepository downloadsInfoRepository;

    public DownloadsInformation createDownload(DownloadsInformation download) {
        return downloadsInfoRepository.save(download);
    }
    
    
    public Map<String, Long> getAllDownloadCountsByArtifactType() {
        List<Object[]> result = downloadsInfoRepository.countAllByArtifactModel_ArtifactType();

        return result.stream()
                .collect(Collectors.toMap(
                        arr -> (String) arr[0],
                        arr -> (Long) arr[1]   
                ));
    }
    
    public Map<Boolean, Long> getDownloadCountByIsUserPublic() {
        return downloadsInfoRepository.countByIsUserPublic();
    }
    
    public Long getDownloadCountByIsPublic(boolean isPublic) {
        return downloadsInfoRepository.countByArtifactModel_IsPublic(isPublic);
    }
}
