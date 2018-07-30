package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.bean.Proof;
import com.spring.service.ProofService;

@RestController
@RequestMapping(value={"/proof"})
public class ProofController {
	@Autowired
	ProofService proofService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proof> getProofById(@PathVariable("id") int id) {
        System.out.println("Fetching Proof with id " + id);
        Proof proof = proofService.findById(id);
        if (proof == null) {
            return new ResponseEntity<Proof>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Proof>(proof, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createProof(@RequestBody Proof proof, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating Proof "+proof.getProofDescription());
	     proofService.createProof(proof);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/proof/{id}").buildAndExpand(proof.getId()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<Proof> getAllProof() {	 
	  List<Proof> tasks=proofService.getProof();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateProof(@RequestBody Proof currentProof)
	{
		System.out.println("sd");
	Proof proof = proofService.findById(currentProof.getId());
	if (proof==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	proofService.update(currentProof, currentProof.getId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<Proof> deleteProof(@PathVariable("id") int id){
		Proof proof = proofService.findById(id);
		if (proof == null) {
			return new ResponseEntity<Proof>(HttpStatus.NOT_FOUND);
		}
		proofService.deleteProofById(id);
		return new ResponseEntity<Proof>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<Proof> updateProofPartially(@PathVariable("id") int id, @RequestBody Proof currentProof){
		Proof proof = proofService.findById(id);
		if(proof ==null){
			return new ResponseEntity<Proof>(HttpStatus.NOT_FOUND);
		}
		Proof usr =	proofService.updatePartially(currentProof, id);
		return new ResponseEntity<Proof>(usr, HttpStatus.OK);
	}
}
