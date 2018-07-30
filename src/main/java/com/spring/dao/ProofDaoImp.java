package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bean.Proof;
@Repository
public class ProofDaoImp implements ProofDao{
	@Autowired
	private SessionFactory sessionFactory;
	  
	public void addProof(Proof proof) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(proof); 
	}

	public List<Proof> getProof() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Proof> list= session.createCriteria(Proof.class).list();
		return list;
	}

	public Proof findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		Proof proof=(Proof) session.get(Proof.class,id);
		return proof;
	}

	public Proof update(Proof val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Proof proof =(Proof)session.get(Proof.class, id);
		/*add necessary collumns */
		
		session.update(proof);
		return proof;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Proof proof = findById(id);
		session.delete(proof);
	}
	@Override
	public Proof updateCountry(Proof val, long id){
		Session session = sessionFactory.getCurrentSession();
		Proof proof = (Proof)session.load(Proof.class, id);
		//proof.setCountry(val.getCountry());
		return proof;
	}

	@Override
	public Proof findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proof update(Proof proof, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
