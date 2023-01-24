package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IBooking;
import dao.IMovie;
import dao.IUser;

import model.Booking;
import model.Movie;
import model.User;

@RestController
public class UserController {
	
	@Autowired
	IMovie movie;
	@Autowired
	IBooking booking;
	@Autowired
	IUser user;
	
	@PostMapping("signup")
	public boolean signup(@RequestBody User b) {
		user.save(b);
		return true; 
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User b) {
		if(user.findById(b.getId()).isPresent()) {
			if(user.findById(b.getId()).get().getName().equals(b.getName())) {
				return "Logged In";
			}
		}
		return "false";
	}
	
	@GetMapping("allMovie")
	public List<Movie> viewMovies() {
		return movie.findAll();
	}
	
	@GetMapping("movie/{id}")
	public String searchMovie(@PathVariable("id") int mid) {
		return movie.findById(mid).get().getMname();
	}

	@PostMapping("book")
	public String addBooking(@RequestBody Booking b) {
		booking.save(b);
		return "Movie Booked"; 
	}
	
	@GetMapping("/allBooking")
	public List<Booking> viewBooking() {
		return booking.findAll();
	}
	
	@DeleteMapping("/cancelBooking/{id}")
	public String cancelBooking(@PathVariable("id") int id) {
		 booking.deleteById(id); 
		 return "booking deleted";
	}
}
