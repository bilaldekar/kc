package com.example.kc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kc.Fournisseur;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/fournisseurs")
public class FournisseurAPI {

	@Autowired
	private FournisseurRepository fournisseurRepository;

	
	@Autowired
	private FournisseurService fournisseurService;

	
	@GetMapping
	public List<Fournisseur> getAllFournisseurs() {
		return fournisseurRepository.findAll();
	}
	

	@PostMapping
	public ResponseEntity<?> saveFournisseur(@RequestBody Fournisseur fournisseur) {

				
				fournisseur = fournisseurService.save(fournisseur);


		return new ResponseEntity<Fournisseur>(fournisseur, HttpStatus.CREATED);

	}
	


}
