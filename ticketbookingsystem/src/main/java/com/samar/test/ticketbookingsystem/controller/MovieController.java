package com.samar.test.ticketbookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.samar.test.ticketbookingsystem.exception.MovieAddException;
import com.samar.test.ticketbookingsystem.exception.TicketBookingException;
import com.samar.test.ticketbookingsystem.model.Movie;
import com.samar.test.ticketbookingsystem.model.Ticket;
import com.samar.test.ticketbookingsystem.service.ServiceClass;

@RestController
public class MovieController {

	@Autowired
	private ServiceClass service;

	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addMovie(@RequestBody Movie movie) throws MovieAddException {
		service.addMovie(movie);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public List<Movie> getMovies() {
		return service.getMovies();

	}
	
	@RequestMapping(value = "/movie/{movieId}/ticket", method = RequestMethod.GET)
	public List<Ticket> getMovieTickets(@PathVariable int movieId) {
		return service.getTicketsForMovie(movieId);

	}
	
	@RequestMapping(value = "/movie/{movieId}/ticket/{ticketId}", method = RequestMethod.POST)
	public ResponseEntity bookMovieTickets(@PathVariable int movieId, @PathVariable int ticketId) throws TicketBookingException {
		service.bookMovieTickets(movieId, ticketId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
