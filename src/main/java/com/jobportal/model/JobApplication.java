package com.jobportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "JOBAPPLICATION")
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "CANDIDATEID")
	private int candidateId;

	@Column(name = "CLIENTID")
	private int clientId;

	@Column(name = "JOBDESCRIPTIONID")
	private int jobDescriptionId;

	@Column(name = "STATE")
	private String state;
	
	@Transient
	private String message;

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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getJobDescriptionId() {
		return jobDescriptionId;
	}

	public void setJobDescriptionId(int jobDescriptionId) {
		this.jobDescriptionId = jobDescriptionId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
