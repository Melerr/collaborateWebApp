package pl.collaborateWebApp.Security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pl.collaborateWebApp.Models.User;
import pl.collaborateWebApp.Models.UserRole;


public class CustomUserDetails implements UserDetails{
	
	private Logger logger = LoggerFactory.getLogger(CustomUserDetails.class);
	
	private String userName;
	private String password;
	private Boolean isActive;
	private Set<GrantedAuthority> authorities;
	

	public CustomUserDetails(User user) {
		this.userName = user.getEmail();
		this.password = user.getPassword();
		this.isActive = user.getIsActive();
		this.authorities = convertAuthorities(user.getRoles());
		
		logger.info("Pos construct, argument input constructor:" + user.toString());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	@Override
	public String getPassword() {
		return password;
	}


	@Override
	public String getUsername() {
		return userName;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return isActive;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return isActive;
	}

	
	private Set<GrantedAuthority> convertAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		for(UserRole ur: userRoles) {
			authorities.add(new SimpleGrantedAuthority(ur.getRole()));
		}
		return authorities;
	}
	
	

}
