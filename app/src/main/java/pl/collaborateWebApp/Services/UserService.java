package pl.collaborateWebApp.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pl.collaborateWebApp.Exceptions.DuplicateUserEmailException;
import pl.collaborateWebApp.Models.User;
import pl.collaborateWebApp.Repositories.UserRepository;
import pl.collaborateWebApp.Repositories.UserRoleRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public UserService(UserRepository userRepo, UserRoleRepository userRoleRepo, PasswordEncoder passwordEncoder) {
		
		this.userRepo = userRepo;
		this.userRoleRepo = userRoleRepo;
		this.passwordEncoder = passwordEncoder;
		
	}
	
	
	public List<User> findAllusers() {
		
		logger.info("UserServcie method: findAllusers");
		
		return userRepo.findAll();
	}
	
	
	public User save(User user) {
		
		logger.info("UserServcie method: save");
		
		User userByEmail = userRepo.findByEmail(user.getEmail());
		
		if(userByEmail!= null) {
			throw new DuplicateUserEmailException();
		}
		
		String passwordHash = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(passwordHash);
		
		User saveUser = userRepo.save(user);
		
		return saveUser;
		
		
	}
	
	
	// mETODA DO USUNIECIA POWINNA - METODA Z REPO POWINNA BYC WYKORZYSTYWANA JAKO POMOCNICZA W METODZIE SAVE
	/*
	public User findUserByEmail(String email) {
		
		logger.info("UserServcie method: findUserByEmail");

		logger.info("UserServcie method: argument email = " + email);
		
		User user = userRepo.findByEmail(email);
		
		logger.info("UserServcie method: finded user by findbyEmail repo = " + user);
		
		if(user == null) {
			logger.info("UserServcie method: user by findbyEmail repo IS NULL");
			//throw new UsernameNotFoundException("User " + email + " not found");
			throw new DuplicateUserEmailException();
		}
		
		logger.info("UserServcie method: finded user by user repo = " + user.toString());
		
		return user;
		
	}*/

}
