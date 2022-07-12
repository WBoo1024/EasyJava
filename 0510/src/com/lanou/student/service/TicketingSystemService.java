package com.lanou.student.service;

import com.lanou.student.bean.TicketingSystem;
import com.lanou.student.mapper.TicketingSystemMapper;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author WANG
 */
public class TicketingSystemService {
	private TicketingSystemMapper ticketingSystemMapper;
	
	public TicketingSystemService() {
		ticketingSystemMapper = new TicketingSystemMapper();
	}

	public boolean add(TicketingSystem ticket) {
		return ticketingSystemMapper.add(ticket);
	}

	public boolean delete(int id) {
		
		return ticketingSystemMapper.delete(id);
	}

	public TicketingSystem[] getTickets() {
		
		return ticketingSystemMapper.getTickets();
	}

	public boolean reMovie(int id, String newMovie) {
		
		return ticketingSystemMapper.reMovie(id,newMovie);
	}

	public boolean reDirector(int id, String newDirector) {
		
		return ticketingSystemMapper.reDirector(id,newDirector);
	}

	public boolean reStarring(int id, String newStarring) {
		
		return ticketingSystemMapper.reStarring(id,newStarring);
	}

	public boolean reType(int id, String newType) {
		return ticketingSystemMapper.newType(id,newType);
	}

	public boolean reArea(int id, String newArea) {
		return ticketingSystemMapper.reArea(id,newArea);
	}

	public boolean reLanguage(int id,String newLanguage){
		return ticketingSystemMapper.reLanguage(id,newLanguage);
	}

	public boolean reRelease (int id,String newRelease){
		return ticketingSystemMapper.reRelease(id, newRelease);
	}
	
}
