package com.nicoz.NZWanderlust.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postID;
	
	private Integer sellerID;	
	private String title;	
	private String description;
	private String startDate;
	private String endDate;
	private String images;	
	private Double price;
	private Integer numberOfTickets;
	private String transport;	
	private String hotel;		
	private String food;
	private String turisticPlan;

	public Post() {
	}
	
	
	
}