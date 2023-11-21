package com.ltim.joritz.marketplace.controller;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltim.joritz.marketplace.model.ArtifactModel;
import com.ltim.joritz.marketplace.model.DownloadsInformation;
import com.ltim.joritz.marketplace.service.ArtifactService;
import com.ltim.joritz.marketplace.service.DownloadInfoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/service/0/marketplace/download")
public class DownloadController {

    @Autowired
    private DownloadInfoService downloadInfoService;

    @Autowired
    private ArtifactService artifactService;

    @PostMapping("create")
    public ResponseEntity<?> createDownload(@Valid @RequestBody DownloadsInformation download,
                                            BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        ArtifactModel artifact = download.getArtifactModel();

        if (!artifactService.isValidArtifact(artifact)) {
            return new ResponseEntity<>("Invalid artifact", HttpStatus.BAD_REQUEST);
        }

        DownloadsInformation createdDownload = downloadInfoService.createDownload(download);
        return new ResponseEntity<>(createdDownload, HttpStatus.CREATED);
    }
    
    
    @GetMapping("countByArtifactType")
    public ResponseEntity<?> getDownloadCountByArtifactType() {
        // Fetch counts for all artifact types
        return new ResponseEntity<>(downloadInfoService.getAllDownloadCountsByArtifactType(), HttpStatus.OK);
    }
    
    @GetMapping("countByIsUserPublic")
    public ResponseEntity<?> getDownloadCountByIsUserPublic() {
        return new ResponseEntity<>(downloadInfoService.getDownloadCountByIsUserPublic(), HttpStatus.OK);
    }

    @GetMapping("countByIsPublic")
    public ResponseEntity<Map<Boolean, Long>> getDownloadCountByIsPublic() {
        // Fetch counts for both true and false values of isPublic
        Map<Boolean, Long> downloadCounts = new HashMap<>();
        
        downloadCounts.put(true, downloadInfoService.getDownloadCountByIsPublic(true));
        downloadCounts.put(false, downloadInfoService.getDownloadCountByIsPublic(false));
        
        return new ResponseEntity<>(downloadCounts, HttpStatus.OK);
    }

}


