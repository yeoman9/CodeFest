package com.spring.bean;

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
@Table(name = "Proof")
public class Proof implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7873314763375593754L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROOF_SEQ")
	@SequenceGenerator(sequenceName = "proof_seq", allocationSize = 1, name = "PROOF_SEQ")
	Long id;
	
	private String erpId;
	private String misId;
	private String misRecordId;
	private String proofVersionID;
	private String fileUploadID;
	private String Status ;
	private String proofDescription;
	private Integer notes;
	@Column(name = "REQUESTED_BY")
    private String requestedBy;
	private String approver;
	
	@Column(name = "APPROVED_DATE")
    private Date approvedDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getErpId() {
		return erpId;
	}
	public void setErpId(String erpId) {
		this.erpId = erpId;
	}
	public String getMisId() {
		return misId;
	}
	public void setMisId(String misId) {
		this.misId = misId;
	}
	public String getMisRecordId() {
		return misRecordId;
	}
	public void setMisRecordId(String misRecordId) {
		this.misRecordId = misRecordId;
	}
	public String getProofVersionID() {
		return proofVersionID;
	}
	public void setProofVersionID(String proofVersionID) {
		this.proofVersionID = proofVersionID;
	}
	public String getFileUploadID() {
		return fileUploadID;
	}
	public void setFileUploadID(String fileUploadID) {
		this.fileUploadID = fileUploadID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getProofDescription() {
		return proofDescription;
	}
	public void setProofDescription(String proofDescription) {
		this.proofDescription = proofDescription;
	}
	public Integer getNotes() {
		return notes;
	}
	public void setNotes(Integer notes) {
		this.notes = notes;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	
}
