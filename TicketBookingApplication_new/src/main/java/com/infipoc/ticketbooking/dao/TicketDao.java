package com.infipoc.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infipoc.ticketbooking.model.Ticket;

@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer>{
	

}
