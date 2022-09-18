package com.jobportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAILID")
	private String emailId;

	@Column(name = "MOBILENUMBER")
	private Integer mobileNumber;

	@Column(name = "TAGS")
	private String tags;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "PROFILE")
	private String profile;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCountryCode() {
		return tags;
	}

	public void setCountryCode(String countryCode) {
		this.tags = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Candidate [Id=" + Id + ", name=" + name + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", tags=" + tags + ", designation=" + designation + ", profile="
				+ profile + "]";
	}

	public boolean validateCandidate() {
		if (designation == null || designation == "") {
			return false;
		}
		if (emailId == null || emailId == "") {
			return false;
		}
		if (name == null || name == "") {
			return false;
		}
		if (profile == null || profile == "") {
			return false;
		}
		
		return true;
	}

}
