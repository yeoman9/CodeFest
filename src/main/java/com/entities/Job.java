package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Job")
public class Job implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731133040075600203L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_SEQ")
	@SequenceGenerator(sequenceName = "job_seq", allocationSize = 1, name = "JOB_SEQ")
	Long id;
	
	private String jobDescription;
	private String jobStatus;
	private String jobContact;
	@Column(name = "PROMISE_DATE")
    private Date promiseDate;
	private String jobPartID;
	private Integer jobPartQty;
	private String jobPartStatus;
	private String salesPerson;
	private String csr;
	private String shipVia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getJobContact() {
		return jobContact;
	}
	public void setJobContact(String jobContact) {
		this.jobContact = jobContact;
	}
	public Date getPromiseDate() {
		return promiseDate;
	}
	public void setPromiseDate(Date promiseDate) {
		this.promiseDate = promiseDate;
	}
	public String getJobPartID() {
		return jobPartID;
	}
	public void setJobPartID(String jobPartID) {
		this.jobPartID = jobPartID;
	}
	public Integer getJobPartQty() {
		return jobPartQty;
	}
	public void setJobPartQty(Integer jobPartQty) {
		this.jobPartQty = jobPartQty;
	}
	public String getJobPartStatus() {
		return jobPartStatus;
	}
	public void setJobPartStatus(String jobPartStatus) {
		this.jobPartStatus = jobPartStatus;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	public String getCsr() {
		return csr;
	}
	public void setCsr(String csr) {
		this.csr = csr;
	}
	public String getShipVia() {
		return shipVia;
	}
	public void setShipVia(String shipVia) {
		this.shipVia = shipVia;
	}
}
