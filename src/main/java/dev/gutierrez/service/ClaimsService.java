package dev.gutierrez.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.gutierrez.model.Claims;
import dev.gutierrez.repository.ClaimsRepository;
import dev.gutierrez.exceptions.*;

@Service
public class ClaimsService {
	private final ClaimsRepository claimsRepository;
	

	public ClaimsService(ClaimsRepository claimsRepository) {
		this.claimsRepository = claimsRepository;
	}
	
	public Claims createClaim(Claims claims) {
		return claimsRepository.save(claims);
	}
	
	
	public List<Claims> findAllClaims(){
		return claimsRepository.findAll();
	}
	
	public Claims updateClaims(Claims claim) {
		return claimsRepository.save(claim);
	}
	
	public Claims findClaimByClaimId(Long id) {
		return claimsRepository.findClaimByClaimId(id).orElseThrow(() -> new ClaimNotFoundException(" The claim you are looking for does not exist."));
		
	}
	

	public void deleteClaim( Long id) {
		claimsRepository.deleteClaimByClaimId(id);
	}

}
