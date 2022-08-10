package dev.gutierrez.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gutierrez.model.Claims;
import dev.gutierrez.model.Customers;
import dev.gutierrez.repository.RegistrationRepository;
import dev.gutierrez.service.RegistrationService;

@CrossOrigin
@RestController
public class RegistrationController {

	Logger logger = LoggerFactory.getLogger(ClaimsController.class);

	// configure the db for this method 
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	public Customers registerUser(@RequestBody Customers user) throws Exception {
		
		logger.info("Register Page Has Been Visited");

		
		String tempEmailId = user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			Customers userObj = service.fetchUserByEmailId(tempEmailId);
			if(userObj != null) {
				throw new Exception("That username is already in use.");
			}
		}
		Customers userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	
	@PostMapping("/login")
	public Customers login(@RequestBody Customers user) throws Exception {
		
		
		logger.info("Login Page Has Been Visited");

		
		String tempEmailId = user.getUserName();
		String tempPass = user.getPassword();
		Customers userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj == null) {
			throw new Exception("User does not exist. Check your credential information.");
		}
		
		return userObj;
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	
	@GetMapping("/getUser/{userName}")
	
	public Customers getUser(@PathVariable String userName) throws Exception {
		logger.info("Looking For Claims PER Customer");
		
		return service.findByUsername(userName);
	}
	
}
	
//	new 
//	@CrossOrigin(origins = "*", allowedHeaders = "*")
//
//	@GetMapping("/users/{id}/claims")
//	public List<Claims> retriveAllUsers(@PathVariable int id) throws Exception {
//		
//		logger.info("Looking For Claims PER Customer");
//		
//		Optional<Customers> userOptional= service.findById(id);  
//		if(!userOptional.isPresent())
//		{
//			throw new Exception("id: "+ id  + " was not found.");  
//		}  
//		return userOptional.get().getClaims();  
//		}  
//		
//	}
	

