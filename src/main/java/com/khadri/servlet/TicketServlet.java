package com.khadri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.dao.TicketDAO;
import com.khadri.model.Ticket;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TicketServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String priceStr = req.getParameter("price");
        String donationStr = req.getParameter("donation");
        String aadhaar = req.getParameter("aadhaar");

        try {
            int age = Integer.parseInt(ageStr);
            double price = Double.parseDouble(priceStr);
            double donation = 0.0;

            if (donationStr != null && !donationStr.trim().isEmpty()) {
                donation = Double.parseDouble(donationStr);
            }

            double total = price + donation;
            Ticket ticket = new Ticket();
            ticket.setName(name);
            ticket.setAge(age);
            ticket.setFrom(from);
            ticket.setTo(to);
            ticket.setPrice(price);
            ticket.setDonation(donation);
            ticket.setAadhaar(aadhaar);
            ticket.setTotalAmount(total);

            ServletContext ctx = getServletContext();
            String url = ctx.getInitParameter("url");
            String username = ctx.getInitParameter("username");
            String password = ctx.getInitParameter("password");

            TicketDAO dao = new TicketDAO(url, username, password);
            dao.saveTicket(name, age, from, to, price, donation, aadhaar);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Ticket Booking Confirmation</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f9f9f9; text-align: center; }");
            out.println("div { background: white; display: inline-block; padding: 20px; margin-top: 50px;");
            out.println("border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.2); }");
            out.println("h2 { color: #2b6cb0; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h2>Ticket Booking Successful!</h2>");
            out.println("<p><b>Name:</b> " + name + "</p>");
            out.println("<p><b>Age:</b> " + age + "</p>");
            out.println("<p><b>From:</b> " + from + "</p>");
            out.println("<p><b>To:</b> " + to + "</p>");
            out.println("<p><b>Ticket Price:</b> " + price + "</p>");
            out.println("<p><b>Donation:</b> " + donation + "</p>");
            out.println("<p><b>Total Amount:</b> " + total + "</p>");
            out.println("<p><b>Aadhaar No:</b> " + aadhaar + "</p>");
            out.println("<h3 style='color:green;'>Thank you for booking with us!</h3>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (NumberFormatException e) {

            out.println("Please enter valid numeric values for Age, Price, and Donation.");
        }
    }
}
