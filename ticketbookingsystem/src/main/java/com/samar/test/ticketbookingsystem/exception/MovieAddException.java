package com.samar.test.ticketbookingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="Movie already exists")
public class MovieAddException extends Exception {

	String msg;

	public MovieAddException(String msg) {
		super();
		this.msg = msg;
	}

}
