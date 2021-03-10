package com.infipoc.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infipoc.ticketbooking.dao.TicketDao;
import com.infipoc.ticketbooking.model.Ticket;

@Service
public class TicketService {
	
	@Autowired
	private TicketDao ticketdao;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketdao.save(ticket);
	}
	
	public Iterable<Ticket> findAllTicket(){
		return ticketdao.findAll();
	}
	
	public Ticket findTicketById(Integer ticketID) {
		return ticketdao.findById(ticketID).orElse(new Ticket());
	}
	
	public Ticket updateTicket(Ticket tsid) {
		Ticket dataObj = findTicketById(tsid.getTicketid());
		dataObj.setEmail(tsid.getEmail());
		dataObj.setDestinationStation(tsid.getDestinationStation());
		dataObj.setPassengerName(tsid.getPassengerName());
		dataObj.setSourceStation(tsid.getSourceStation());
		dataObj.setTravelDate(tsid.getTravelDate());
		return ticketdao.save(dataObj);
	}
	
	public void deleteTicket(Integer ticketId) {
		 ticketdao.deleteById(ticketId);
		 
	}
	
}
