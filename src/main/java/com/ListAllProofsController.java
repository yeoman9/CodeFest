package com;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.Proof;
import com.spring.controller.ProofController;

@Controller
public class ListAllProofsController {

	@Autowired
	ProofController proofController;
	private List<Proof> proofs;
	@RequestMapping("/getProofs")
	public String getAllProofs(Model md) {
		
		proofs = proofController.getAllProof();
		
		md.addAttribute("proofs", proofs);
        return "listAllProofs";
		
	}

}