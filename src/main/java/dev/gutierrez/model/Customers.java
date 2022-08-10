package dev.gutierrez.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;




@Entity 
public class Customers {
	
@Id 
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;


//@GeneratedValue(strategy =  GenerationType.AUTO)
//private long claimId;

//@OneToMany(mappedBy = "customer")
//private List<Claims> claims;

//public List<Claims> getClaims() {
//	return claims;
//}
//public void setClaims(List<Claims> claims) {
//	this.claims = claims;
//}
@NotNull 
@Column(name = "first_name")
private String firstName;

@NotNull
@Column(name = "last_name")
private String lastName;


@Column(name = "email_Id")
private String emailId;


@Column(name = "user_name")
private String userName;

@Column(name = "password")
private String password;

//getters and setters
public long getId() {
	return id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public void setId(long id) {
	this.id = id;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



public Customers(long id, String firstName, String lastName, String emailId, String userName, String password) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.userName = userName;
	this.password = password;
}
public Customers() {
	
}

}
