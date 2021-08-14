package com.fitzgerald.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="languages")
public class Language {
	
		//------------------------------design for data --- what the schema will be and do
		
			//---id of programming language
	    	@Id
	    	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    	//-- name of language
	    	@NotNull
	    @Size(min = 2, max = 200, message="language must be larger than 2 characters and less than 200")
	    private String languageName;
	   
	    
	    	//-- name of creator 
	    	@NotNull
	    @Size(min = 2, max = 200, message="creator name must be larger than 2 characters and less than 200")
	    private String creator;
	    
	    	//-- latest version of programming language
	    	@NotNull
	    private double version;
	    
	    
	    	//-- created at and updated at
	    	@Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    //-- empty constructor
	    public Language() {
	    }
	    
	    //-- constructor
	    public Language(String languageName, String creator, double version) {
	        this.languageName = languageName;
	        this.creator = creator;
	        this.version = version;
	    }
	  
		//-- persistent data methods
		@PrePersist
		protected void onCreate(){
		    this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate(){
		    this.updatedAt = new Date();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLanguageName() {
			return languageName;
		}

		public void setLanguageName(String languageName) {
			this.languageName = languageName;
		}

		public String getCreator() {
			return creator;
		}

		public void setCreator(String creator) {
			this.creator = creator;
		}

		public double getVersion() {
			return version;
		}

		public void setVersion(double version) {
			this.version = version;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		
		//--getters and setters
		
}
