package dev.gutierrez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.gutierrez.model.Customers;

public interface RegistrationRepository extends JpaRepository<Customers, Integer>{
	
	
//	@Query("SELECT u from Customer u WHERE u.user_name = ?1")
	public Customers findCustomersByUserName(String username);

	public Customers findByUserNameAndPassword(String username, String password);
	
	

}
