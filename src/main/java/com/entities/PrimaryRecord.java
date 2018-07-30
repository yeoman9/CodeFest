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
@Table(name = "PrimaryRecord")
public class PrimaryRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4397083863814995342L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRIMARY_RECORD_SEQ")
	@SequenceGenerator(sequenceName = "primaryRecord_seq", allocationSize = 1, name = "PRIMARY_RECORD_SEQ")
	Long id;
	
	private String erpId;
	private String misId;
	private String misRecordId;
	
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
}
