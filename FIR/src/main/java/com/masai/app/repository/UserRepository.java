package com.masai.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.app.entity.Fir;
import com.masai.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("Select password from User where userName=?1")
	public String validateUser(String username);
	@Query("Select fir from User where userId=?1")
	public List<Fir> findFir(int id);
}
