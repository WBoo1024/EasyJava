package com.lanou.student.controller;

import com.lanou.student.bean.TicketingSystem;
import com.lanou.student.service.TicketingSystemService;

public class TicketingSystemController {
	private TicketingSystemService ticketingSystemService;
	
	public TicketingSystemController() {

		ticketingSystemService = new TicketingSystemService();
	}
	
	public  boolean add(TicketingSystem ticket) {
		return ticketingSystemService.add(ticket);
	}

	public boolean delete(int id) {
		return ticketingSystemService.delete(id);
	}

	public TicketingSystem[] getTickets() {
		return ticketingSystemService.getTickets();
	}

	public boolean reMovie(int id, String newMovie) {
		return ticketingSystemService.reMovie(id,newMovie);
	}

	public boolean reDirector(int id,String newDirector) {
		return ticketingSystemService.reDirector(id,newDirector);
	}

	public boolean reStarring(int id, String newStarring) {
		return ticketingSystemService.reStarring(id,newStarring);
	}

	public boolean reType(int id, String newType) {
		return ticketingSystemService.reType(id,newType);
	}

	public boolean reArea(int id, String newArea) {
		return ticketingSystemService.reArea(id,newArea);
	}

	public boolean reLanguage(int id,String newLanguage){
		return ticketingSystemService.reLanguage(id, newLanguage);
	}

	public boolean reRelease(int id,String newRelease){
		return ticketingSystemService.reRelease(id, newRelease);
	}

	

}
