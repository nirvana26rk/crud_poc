package com.infipoc.ticketbooking.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infipoc.ticketbooking.model.Ticket;
import com.infipoc.ticketbooking.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping(value = "/index")
	public String showUserList(Model model) {
		model.addAttribute("users", ticketService.findAllTicket());
		return "index";
	}
	
	@GetMapping("/signup")
    public String showSignUpForm(Ticket ticket) {
        return "add-user";
    }
	
	@PostMapping(value = "/create")
	public String createTicket(@Valid Ticket ticket, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		ticketService.createTicket(ticket);
		return "redirect:/index";

	}

	@RequestMapping(value = ("/find/{ticketId}"), method = RequestMethod.GET)
	public String getTicketById(@PathVariable("ticketId") Integer ticketId, Model model) {
		Ticket ticket = ticketService.findTicketById(ticketId);
		model.addAttribute("user", ticket);
		return "update-user";
	}
	

	@RequestMapping(value = ("/update/{ticketId}"),method =  RequestMethod.POST)
    public String updateUser(@PathVariable("ticketId") Integer ticketId, Model model, @Valid Ticket ticket, BindingResult result) {
        if (result.hasErrors()) {
        	ticket.setTicketid(ticketId);
           return "update-user";
        }
        
        ticketService.updateTicket(ticket);

        return "redirect:/index";
    }

	@RequestMapping(value = ("/delete/{ticketId}"),method = { RequestMethod.GET, RequestMethod.DELETE})
	public String deleteTicket(@PathVariable("ticketId") Integer ticketId, Model model) {
		ticketService.deleteTicket(ticketId);
		return "redirect:/index";
	}

}
