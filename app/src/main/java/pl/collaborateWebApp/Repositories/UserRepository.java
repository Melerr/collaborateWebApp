package pl.collaborateWebApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.collaborateWebApp.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
		
	User findByEmail(String email);
	
}
