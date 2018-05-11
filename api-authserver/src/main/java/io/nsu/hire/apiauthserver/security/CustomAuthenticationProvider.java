package io.nsu.hire.apiauthserver.security;

import io.nsu.hire.apiauthserver.cnfg.PasswordEncoderHelper;
import io.nsu.hire.apiauthserver.rest.dto.PermissionDTO;
import io.nsu.hire.apiauthserver.rest.dto.UserDTO;
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
		String password = PasswordEncoderHelper.getPasswordEncoder().encode(authentication.getCredentials().toString());
		UserDTO user = userService.readUserByEmail(username).orElseThrow(() -> new BadCredentialsException("1000"));
		List<PermissionDTO> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> authorities.addAll(role.getPermissionList()));
		return new UsernamePasswordAuthenticationToken(user, password, authorities);

	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}

}
