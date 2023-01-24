package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.User;

public interface IUser extends JpaRepository<User, Integer> {

}
