package com.samar.test.ticketbookingsystem.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.samar.test.ticketbookingsystem.exception.MovieAddException;
import com.samar.test.ticketbookingsystem.exception.TicketBookingException;
import com.samar.test.ticketbookingsystem.model.Movie;
import com.samar.test.ticketbookingsystem.model.Ticket;

@Service
public class ServiceClass {

	private static Map<Integer, Movie> movieMap = new HashMap<>();

	public void addMovie(Movie movie) throws MovieAddException {
		Movie m = new Movie(movie.getName(), movie.getTicketPrice());
		int id = movieMap.size() + 1;
		m.setId(id);
		if (movieMap.containsValue(m)) {
			throw new MovieAddException("Movie already exists");
		}
		movieMap.put(id, m);
	}

	public List<Movie> getMovies() {
		List<Movie> list = new ArrayList<>();
		list.addAll(movieMap.values());
		return list;
	}

	public List<Ticket> getTicketsForMovie(int id) {

		Movie m = movieMap.get(id);
		if (m == null) {

		}
		return m.getTickets();
	}

	public void bookMovieTickets(int movieId, int ticketId) throws TicketBookingException {
		Movie m = movieMap.get(movieId);
		List<Ticket> tickets = m.getTickets();
		
		Ticket t = tickets.get(ticketId-1);
		if(t.getBookingTime()!= null) {
			Calendar prev = Calendar.getInstance();
			prev.setTime(t.getBookingTime());
			
			Calendar now = Calendar.getInstance();
			long diff = now.getTimeInMillis() - prev.getTimeInMillis();
			if(diff <= 2* 60* 1000) {
				throw new TicketBookingException("Ticket is locked");
			}
		}
		t.setBookingTime(new Date());
	}

}
