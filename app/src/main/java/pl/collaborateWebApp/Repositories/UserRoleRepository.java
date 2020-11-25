package pl.collaborateWebApp.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.collaborateWebApp.Models.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	//Optional<UserRole> findByRole(String role);
	UserRole findByRole(String role);

}
