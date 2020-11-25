package pl.collaborateWebApp.Controllers;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pl.collaborateWebApp.Exceptions.DuplicateUserEmailException;
import pl.collaborateWebApp.Models.User;
import pl.collaborateWebApp.Services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("/allRegister")
	public List<User> getAllRegisterUsers() {
		return userService.findAllusers();
	}
	
	@GetMapping("/{id}")
	public String getUser() {
		return "Dostęp po autoryzacji dla uzytkownika";
	}
	

	@PostMapping(path= "/register",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		logger.info("START: Controller api/users/register");
		
		
		if(user.getId() != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id użytkownika jest nie puste");
		}
		
		
		User usertoSave = userService.save(user);
			
	    URI location = ServletUriComponentsBuilder
	    		.fromCurrentRequest()
	    		.path("/{id}")
	            .buildAndExpand(usertoSave.getId())
	            .toUri();
	    return ResponseEntity.created(location).body(usertoSave);

	}

}
