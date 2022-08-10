package dev.gutierrez.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Claims{
	


public Claims() {
		super();
	}

public Claims(Long claimId, Customers customer, BigDecimal amount, String description, String imageURL) {
		super();
		this.claimId = claimId;
		this.customer = customer;
//		this.customerId = customerId;
		this.amount = amount;
		this.description = description;
		this.file = imageURL;
	}


public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	
	
	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	@PrePersist
	public void onCreate( ) {
		this.createdAt = new Date();
	}
	

@Id
@Column(name="claim_id") 
@GeneratedValue(strategy =  GenerationType.AUTO)
private long claimId;


@ManyToOne(cascade = CascadeType.MERGE) 
//@JoinColumn(name="customer_id")
private Customers customer;

@Column(updatable = false)
private Date createdAt;

@Column(name="claim_amount_requested")
private BigDecimal amount;

@Column(name="description")
private String description;



@Column(name = "attachment")
private String file;




}
