package com.jobportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOBHISTORY")
public class JobHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "CANDIDATEID")
	private int candidateId;

	@Column(name = "JOBDESCRIPTIONID")
	private int jobDescriptionId;

	@Column(name = "JOBAPPLICATIONID")
	private int jobApplicationId;

	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "UPDATEDON")
	private Date updatedOn;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getJobDescriptionId() {
		return jobDescriptionId;
	}

	public void setJobDescriptionId(int jobDescriptionId) {
		this.jobDescriptionId = jobDescriptionId;
	}

	public int getJobApplicationId() {
		return jobApplicationId;
	}

	public void setJobApplicationId(int jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	
}
