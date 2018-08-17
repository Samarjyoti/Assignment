package com.samar.test.ticketbookingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Ticket is locked")
public class TicketBookingException extends Exception {
	String msg;

	public TicketBookingException(String msg) {
		super();
		this.msg = msg;
	}
}
