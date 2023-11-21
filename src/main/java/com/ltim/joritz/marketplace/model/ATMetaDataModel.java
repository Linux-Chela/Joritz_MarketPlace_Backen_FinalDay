package com.ltim.joritz.marketplace.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="`ATMetaData`")
public class ATMetaDataModel extends AuditableBaseModel{
	
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="`atMetaDataId`")
	private int atMetaDataId;
	
	
	@ManyToOne
	@JoinColumn(name="`atMDSchemaId`") 
	private ATMetaDataSchemaModel atMetaDataSchemaModel;
	 
	 
	 @ManyToOne
	 @JoinColumn(name="`artifactId`")
	 private ArtifactModel artifact;
	 
	 
	 
	 @Column(name="`value`")
	 private String value;



	public int getAtMetaDataId() {
		return atMetaDataId;
	}



	public void setAtMetaDataId(int atMetaDataId) {
		this.atMetaDataId = atMetaDataId;
	}



	public ATMetaDataSchemaModel getAtMetaDataSchemaModel() {
		return atMetaDataSchemaModel;
	}



	public void setAtMetaDataSchemaModel(ATMetaDataSchemaModel atMetaDataSchemaModel) {
		this.atMetaDataSchemaModel = atMetaDataSchemaModel;
	}



	public ArtifactModel getArtifact() {
		return artifact;
	}



	public void setArtifact(ArtifactModel artifact) {
		this.artifact = artifact;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public ATMetaDataModel( ATMetaDataSchemaModel atMetaDataSchemaModel, ArtifactModel artifact,
			String value) {
		super();
//		this.atMetaDataId = atMetaDataId;
		this.atMetaDataSchemaModel = atMetaDataSchemaModel;
		this.artifact = artifact;
		this.value = value;
		
	}



	public ATMetaDataModel() {
		super();
	}



	@Override
	public String toString() {
		return "ATMetaDataModel [atMetaDataId=" + atMetaDataId + ", atMetaDataSchemaModel=" + atMetaDataSchemaModel
				+ ", artifact=" + artifact + ", value=" + value + "]";
	}





	 


	 
	
	
	
}


