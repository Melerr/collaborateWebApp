package pl.collaborateWebApp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Home {
	
	@GetMapping("/home")
	public String home() {
		return "Hello TEST";
	}
	
	@GetMapping("/appUser")
	public String userContent() {
		return "Dostęp po autoryzacji dla uzytkownika";
	}
	
	@GetMapping("/appAdmin")
	public String adminContent() {
		return "Dostęp po autoryzacji dla Adminów";
	}
	
	@GetMapping("/logmeout")
	public String logout() {
		return "WYLOGOWANO";
	}
	

}
