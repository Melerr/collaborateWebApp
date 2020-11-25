package pl.collaborateWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import pl.collaborateWebApp.Models.User;
import pl.collaborateWebApp.Models.UserRole;
import pl.collaborateWebApp.Repositories.UserRepository;
import pl.collaborateWebApp.Services.UserService;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = pl.collaborateWebApp.Repositories.UserRepository.class)
public class AppApplication {


	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		
		/*
		 ConfigurableApplicationContext ctx = 
	                SpringApplication.run(AppApplication.class, args);
		 
		 
		 UserRepository userRepo = ctx.getBean(UserRepository.class);
		 
		 User us = userRepo.findByEmail("AdamM@gmail.com");
		 
		 System.out.println(us);
		*/
	}
	
	
}
