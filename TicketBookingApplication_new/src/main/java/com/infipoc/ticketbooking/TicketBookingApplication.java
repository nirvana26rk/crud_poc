package com.infipoc.ticketbooking;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.infipoc.ticketbooking.service.TicketService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.infipoc.ticketbooking"})
@EnableJpaRepositories(basePackages="com.infipoc.ticketbooking.dao")
@EnableTransactionManagement
@EntityScan(basePackages="com.infipoc.ticketbooking.model")
public class TicketBookingApplication{
	
	@Autowired
	TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}


}
