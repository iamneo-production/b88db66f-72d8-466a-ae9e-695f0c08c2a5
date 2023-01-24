package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Movie;

public interface IMovie  extends JpaRepository<Movie, Integer>{

}