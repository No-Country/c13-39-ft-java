package com.nicoz.NZWanderlust.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;



@Entity
@Data
public class Buyer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;
	private String address;	
	private String phoneNumber;	
	private Integer buyerLevelID;

	public Buyer() {
	}
	
	
	
}