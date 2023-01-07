package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.entity.Fir;
import com.masai.app.entity.Login;
import com.masai.app.entity.User;
import com.masai.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository rep;
	
	public User newUser(User user) {
		return rep.save(user);
	}
	
	public String postUser(Login login) {
		String password=rep.validateUser(login.getUserName());
		System.out.println(password+' '+login.getPassword());
		if (password.equals(login.getPassword()))
			return "Logged in";
		else
			return "Incorrect username or password";
	}
	
	public User newFir(int id,Fir fir) {
		User user=rep.findById(id).get();
		user.getFir().add(fir);
		fir.setUser(user);
		return rep.save(user);
	}
	
	public List<Fir> allFir(int userId) {
		return rep.findFir(userId);
	}
}
