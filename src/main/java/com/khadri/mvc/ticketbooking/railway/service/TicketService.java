package com.khadri.mvc.ticketbooking.railway.service;

import com.khadri.mvc.ticketbooking.controller.form.TicketForm;
import com.khadri.mvc.ticketbooking.dao.TicketDao;
import com.khadri.mvc.ticketbooking.service.dto.TicketFormDto;
import com.khadri.mvc.ticketbooking.service.mapper.TicketFormDtoMapper;

public class TicketService {
	 private TicketDao dao;
	    private TicketFormDtoMapper mapper;

	    public TicketService() {
	        dao = new TicketDao();
	        mapper = new TicketFormDtoMapper();
	    }

	    public int invokeTicketBooking(TicketForm form) {
	        TicketFormDto dto = mapper.map(form);
	        return dao.saveTicket(dto);
	    }
}
