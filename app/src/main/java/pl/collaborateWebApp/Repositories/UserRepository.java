package pl.collaborateWebApp.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.collaborateWebApp.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		
	//Optional<User> findByEmail(String email);
	User findByEmail(String email);
	
}
