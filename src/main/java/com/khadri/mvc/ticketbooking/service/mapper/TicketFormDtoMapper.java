package com.khadri.mvc.ticketbooking.service.mapper;

import com.khadri.mvc.ticketbooking.controller.form.TicketForm;
import com.khadri.mvc.ticketbooking.service.dto.TicketFormDto;

public class TicketFormDtoMapper {
	 public TicketFormDto map(TicketForm form) {
	        TicketFormDto dto = new TicketFormDto();
	        dto.setName(form.getName());
	        dto.setFrom(form.getFrom());
	        dto.setTo(form.getTo());
	        dto.setAge(form.getAge());
	        dto.setPrice(form.getPrice());
	        dto.setDonation(form.getDonation());
	        dto.setAadhaar(form.getAadhaar());
	        return dto;
	    }
}
