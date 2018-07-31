package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bean.Proof;
import com.spring.dao.ProofDao;

@Service
@Transactional
public class ProofServiceImp implements ProofService {
	@Autowired
	ProofDao proofDao;


	public List<Proof> getProof() {
		// TODO Auto-generated method stub
		return proofDao.getProof();
	}

	public Proof findById(long id) {
		// TODO Auto-generated method stub
		return proofDao.findById(id);
	}

	public void createProof(Proof proof) {
		// TODO Auto-generated method stub
		proofDao.addProof(proof);
	}

	public void deleteProofById(long id) {
		// TODO Auto-generated method stub
		proofDao.delete(id);
	}
	@Override
	public Proof updatePartially(Proof proof, long id) {
		proofDao.updateCountry(proof,id);
		return proofDao.findById(id);
	}

	@Override
	public Proof update(Proof proof,long id) {
		// TODO Auto-generated method stub
		return proofDao.update(proof, id);
	}

	
	

	

}
