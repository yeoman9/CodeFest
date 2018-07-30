package com.spring.dao;

import java.util.List;

import com.spring.bean.Proof;

public interface ProofDao {
	public void addProof(Proof proof);
	public List<Proof> getProof();
	public Proof findById(long id);
	public Proof update(Proof proof, long id);
	public Proof updateCountry(Proof proof, long id);
	public void delete(long id);
	
}
