package com.nicoz.NZWanderlust.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserLevel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userLevelID;
	private String levelName;	
	private Integer numberOfTickets;
	private Double profit;
	private Integer userID;

	public UserLevel() {
	}
	
	
	
}