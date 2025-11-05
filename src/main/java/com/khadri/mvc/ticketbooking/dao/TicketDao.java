package com.khadri.mvc.ticketbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.khadri.mvc.ticketbooking.connection.DBConnection;
import com.khadri.mvc.ticketbooking.service.dto.TicketFormDto;

public class TicketDao {
	public int saveTicket(TicketFormDto dto) {
        int count = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
            	    "INSERT INTO public.tickets (name, age, from_city, to_city, price, donation, aadhar) VALUES (?, ?, ?, ?, ?, ?, ?)"
            	);


            ps.setString(1, dto.getName());
            ps.setInt(2, dto.getAge());
            ps.setString(3, dto.getFrom());
            ps.setString(4, dto.getTo());
            ps.setDouble(5, dto.getPrice());
            ps.setDouble(6, dto.getDonation());
            ps.setString(7, dto.getAadhaar());

            count = ps.executeUpdate();
            System.out.println(" SQL executed: " + ps);
            System.out.println(" Rows affected: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
