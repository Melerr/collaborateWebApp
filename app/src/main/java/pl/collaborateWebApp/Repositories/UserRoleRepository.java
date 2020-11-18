package pl.collaborateWebApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.collaborateWebApp.Models.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	UserRole findByRole(String role);

}
