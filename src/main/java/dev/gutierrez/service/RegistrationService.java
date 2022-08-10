package dev.gutierrez.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.gutierrez.model.Customers;
import dev.gutierrez.repository.RegistrationRepository;

@Service 
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	public Customers saveUser(Customers user) {
		
		return repo.save(user);
		 
	 }
	
	public Customers fetchUserByEmailId(String email) {
		return repo.findCustomersByUserName(email);
	}
	
	public Customers fetchUserByEmailIdAndPassword(String email, String password) {
		return repo.findByUserNameAndPassword(email, password);
	}

	public Optional<Customers> findById(int id) {
		return repo.findById(id);
	}

	public Customers findByUsername(String userName) {
		
		return repo.findCustomersByUserName(userName);
	}
}
