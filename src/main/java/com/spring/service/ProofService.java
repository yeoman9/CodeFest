package com.spring.service;

import java.util.List;

import com.spring.bean.Proof;

public interface ProofService {
	public void createProof(Proof proof);
	public List<Proof> getProof();
	public Proof findById(long id);
	public Proof update(Proof proof, long id);
	public void deleteProofById(long id);
	public Proof updatePartially(Proof proof, long id);
}
