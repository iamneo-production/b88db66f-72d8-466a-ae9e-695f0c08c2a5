package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.IBooking;
import dao.IMovie;
import model.Booking;
import model.Movie;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IMovie movie;
	@Autowired
	IBooking booking;

	@GetMapping("/")
	public List<Movie> viewMovies() {
		return movie.findAll();
	}

	@PostMapping("/movie")
	public String addMovie(@RequestBody Movie b) {
		movie.save(b);
		return "Movie Added";
	}

	@DeleteMapping("/movie/{id}")
	public String deleteMovie(@PathVariable("id") int mid) {
		movie.deleteById(mid);
		return "Movie deleted";
	}

	@PutMapping("/movie/{id}")
	public String updateMovie(@RequestBody Movie b, @PathVariable("id") int mid) {
		movie.findById(mid).map(update -> {
			update.setMname(b.getMname());
			return movie.save(update);
		});
		return "updated";
	}

	@GetMapping("/allBooking")
	public List<Booking> viewBooking() {
		return booking.findAll();
	}
	
}

