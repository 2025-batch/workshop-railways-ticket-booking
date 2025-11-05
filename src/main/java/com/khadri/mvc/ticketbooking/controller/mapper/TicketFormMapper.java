package com.khadri.mvc.ticketbooking.controller.mapper;

import com.khadri.mvc.ticketbooking.controller.form.TicketForm;

public class TicketFormMapper {
	public TicketForm map(String name, String from, String to, int age, double price, double donation, String aadhaar) {
        TicketForm form = new TicketForm();
        form.setName(name);
        form.setFrom(from);
        form.setTo(to);
        form.setAge(age);
        form.setPrice(price);
        form.setDonation(donation);
        form.setAadhaar(aadhaar);
        return form;
    }
}
