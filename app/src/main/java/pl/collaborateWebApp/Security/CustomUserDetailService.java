package pl.collaborateWebApp.Security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.collaborateWebApp.Models.User;
import pl.collaborateWebApp.Repositories.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);


	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(userName);
		if(user == null)
			throw new UsernameNotFoundException("User " + userName + " not found");
		
		logger.info("Obiekt user: " + user.toString());
		
		return new CustomUserDetails(user);
	}

}
