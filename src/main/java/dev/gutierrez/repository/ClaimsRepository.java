package dev.gutierrez.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gutierrez.model.Claims;

public interface ClaimsRepository extends JpaRepository <Claims, Long > {

	void deleteClaimByClaimId(Long id);

	Optional<Claims> findClaimByClaimId(Long id);

	Claims save(Long id);
	

}
