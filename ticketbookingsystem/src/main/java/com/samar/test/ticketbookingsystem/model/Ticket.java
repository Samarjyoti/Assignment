package com.samar.test.ticketbookingsystem.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "bookingTime" }, allowGetters = false)
public class Ticket {

	private int ticketNo;
	private Date bookingTime;

	public Ticket(int ticketNo) {
		super();
		this.ticketNo = ticketNo;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

}
