package com.ltim.joritz.marketplace.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="`ArtifactType`")
public class ArtifactTypeModel extends AuditableBaseModel{

	@Id
	@Column(name="`artifactTypeId`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int artifactTypeId;
	
	@Column(name="artifactCategory")
	private String artifactCategory;
	
	@Column(name="status")
	private boolean status;

	public int getArtifactTypeId() {
		return artifactTypeId;
	}

	public void setArtifactTypeId(int artifactTypeId) {
		this.artifactTypeId = artifactTypeId;
	}

	public String getArtifactName() {
		return artifactCategory;
	}

	public void setArtifactName(String artifactCategory) {
		this.artifactCategory = artifactCategory;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArtifactTypeModel(int artifactTypeId, String artifactCategory, boolean status) {
		super();
		this.artifactTypeId = artifactTypeId;
		this.artifactCategory = artifactCategory;
		this.status = status;
	}

	public ArtifactTypeModel() {
		super();
	}

	@Override
	public String toString() {
		return "ArtifactTypeModel [artifactTypeId=" + artifactTypeId + ", artifactCategory=" + artifactCategory + ", status="
				+ status + "]";
	}

	
	
	
	
}
