package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Booking;

public interface IBooking extends JpaRepository<Booking, Integer> {
    
}
