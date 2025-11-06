package com.khadri.mvc.ticketbooking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.ticketbooking.connection.DBConnection;
import com.khadri.mvc.ticketbooking.controller.form.TicketForm;
import com.khadri.mvc.ticketbooking.controller.mapper.TicketFormMapper;
import com.khadri.mvc.ticketbooking.service.TicketService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TicketServlet extends HttpServlet {

    private TicketService service;
    private TicketFormMapper mapper;

    @Override
    public void init() throws ServletException {
        service = new TicketService();
        mapper = new TicketFormMapper();

        ServletContext context = getServletContext();
        String un = context.getInitParameter("username");
        String pwd = context.getInitParameter("password");
        String url = context.getInitParameter("url");
        String driver = context.getInitParameter("driver");

        DBConnection.createConnection(driver, url, un, pwd);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("TicketServlet service(-.-)");
        
        PrintWriter pw = resp.getWriter();

        try {
            String name = req.getParameter("name");
            String from = req.getParameter("from");
            String to = req.getParameter("to");
            int age = Integer.parseInt(req.getParameter("age"));
            double price = Double.parseDouble(req.getParameter("price"));

            // Handle optional donation safely
            String donationStr = req.getParameter("donation");
            double donation = 0.0;
            if (donationStr != null && !donationStr.trim().isEmpty()) {
                donation = Double.parseDouble(donationStr);
            }

            String aadhaar = req.getParameter("aadhaar");

            TicketForm form = mapper.map(name, from, to, age, price, donation, aadhaar);

            int result = service.invokeTicketBooking(form);

            if (result > 0) {
                pw.println("<h2>Ticket Booked Successfully!</h2>");
            } else {
                pw.println("<h2>Booking Failed. Try Again!</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h2>Error processing your request. Please check inputs.</h2>");
        }
    }
}
