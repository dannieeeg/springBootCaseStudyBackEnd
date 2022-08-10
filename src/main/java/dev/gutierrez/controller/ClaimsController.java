package dev.gutierrez.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gutierrez.exceptions.ClaimNotFoundException;
import dev.gutierrez.model.Claims;
import dev.gutierrez.service.ClaimsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/claims")
public class ClaimsController {
	
	Logger logger = LoggerFactory.getLogger(ClaimsController.class);
	
	
	
	private final ClaimsService claimsService;
	
	public ClaimsController(ClaimsService claimsService) {
		this.claimsService = claimsService;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/findall")
	public ResponseEntity<List<Claims>> getAllClaims(){
		
	
		logger.info("Retrieving all claims");
		
		List<Claims> claims = claimsService.findAllClaims();
		return new ResponseEntity<>(claims, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@GetMapping("/find/{id}")
	public ResponseEntity<Claims> getClaimById(@PathVariable("id") Long id){
		
		logger.info("Retrieving specific claim");

		
		Claims claims = claimsService.findClaimByClaimId(id);
		return new ResponseEntity<>(claims, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@PostMapping("/create")
	public ResponseEntity<Claims> createClaim(@RequestBody Claims claims){
		
		logger.info("Making A New Claim");

		
		Claims newClaims  =  claimsService.createClaim(claims);
//		System.out.println(newClaims.toString());
		
		
//		delete print line for assessor 
		return new ResponseEntity<>(newClaims, HttpStatus.CREATED);

	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@PutMapping("/update/{id}")
	public ResponseEntity<Claims> updateClaims(@PathVariable("id") Long id,
		@RequestBody Claims claimsDetails)throws ClaimNotFoundException{
		
		logger.info("Updating Specific Claim");

		
		Claims claims = Optional.of(claimsService.findClaimByClaimId(id)).orElseThrow(()-> new ClaimNotFoundException(" This Claim was not found"));
		System.out.println(claimsDetails);
		claims.setAmount(claimsDetails.getAmount());
		claims.setDescription(claimsDetails.getDescription());
		claims.setFile(claimsDetails.getFile());
		Claims updatedClaim = claimsService.updateClaims(claims);
		return new ResponseEntity<Claims>(updatedClaim, HttpStatus.OK);

	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteClaim(@PathVariable("id") Long id) {
		 
		logger.info("Deleted Specific Claims");

		
		claimsService.deleteClaim(id);
		return new ResponseEntity<>( HttpStatus.OK);

	}

}
