package com.infipoc.ticketbooking.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_ticket")

public class Ticket {
	
	@Id
	@Column(name="ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketid;
	
	@Column(name="passenger_name")
	@NotBlank
	private String passengerName;

	@Column(name="source_station")
	@NotBlank
	private String sourceStation;
	
	@Column(name="destination_station")
	@NotBlank
	private String destinationStation;
	
	
	  @Column(name="travel_date")
	  
	  @NotBlank private Date travelDate;
	 
	@NotBlank
	private String email;

	public Integer getTicketid() {
		return ticketid;
	}

	
	  public void setTicketid(Integer ticketid) { this.ticketid = ticketid; }
	 

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	
	  public Date getTravelDate() { return travelDate; }
	 

	
	  public void setTravelDate(Date travelDate) { this.travelDate = travelDate; }
	 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Ticket(Integer ticketid, String passengerName, String sourceStation, String destinationStation, String email) {
		super();
		this.ticketid = ticketid;
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		//this.travelDate = travelDate;
		this.email = email;
	}
	
	public Ticket() {
		
	}
		
}
