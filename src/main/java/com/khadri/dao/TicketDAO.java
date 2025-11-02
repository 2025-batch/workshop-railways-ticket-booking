package com.khadri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TicketDAO {
    private String url;
    private String username;
    private String password;

    public TicketDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void saveTicket(String name, int age, String fromCity, String toCity,
                           double price, double donation, String aadhar) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO public.tickets (name, age, from_city, to_city, price, donation, aadhar) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, fromCity);
            ps.setString(4, toCity);
            ps.setDouble(5, price);
            ps.setDouble(6, donation);
            ps.setString(7, aadhar);

            int rows=ps.executeUpdate();
            System.out.println("Rows inserted " + rows);
            ps.close();
            con.close();

            System.out.println("Ticket inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
