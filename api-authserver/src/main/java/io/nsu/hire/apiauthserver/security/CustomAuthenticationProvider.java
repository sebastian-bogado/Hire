package io.nsu.hire.apiauthserver.security;

import com.nsu.duhire.webapi.authserver.model.Permission;
import io.nsu.hire.apiauthserver.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		UserDTO user = userService.readUserByEmail(username).orElseThrow(() -> new BadCredentialsException("1000")); //TODO change exception
		List<Permission> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> authorities.addAll(role.getPermissions()));
		return new UsernamePasswordAuthenticationToken(username, password, authorities);

	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}

}
