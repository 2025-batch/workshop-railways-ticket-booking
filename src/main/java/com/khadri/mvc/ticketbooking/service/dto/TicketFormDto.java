package com.khadri.mvc.ticketbooking.service.dto;

public class TicketFormDto {
	private String name;
    private String from;
    private String to;
    private int age;
    private double price;
    private double donation;
    private String aadhaar;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getDonation() { return donation; }
    public void setDonation(double donation) { this.donation = donation; }

    public String getAadhaar() { return aadhaar; }
    public void setAadhaar(String aadhaar) { this.aadhaar = aadhaar; }
}
