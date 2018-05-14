package io.nsu.hire.apiauthserver.security;

import io.nsu.hire.apiauthserver.rest.dto.PermissionDTO;
import io.nsu.hire.apiauthserver.rest.dto.UserDTO;
import io.nsu.hire.apiauthserver.rest.service.UserService;
import io.nsu.hire.apiauthserver.security.helper.PasswordEncoderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private PasswordEncoder passwordEncoder = PasswordEncoderHelper.getBCryptPasswordEncoder();

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		Optional<UserDTO> user = userService.authenticateUser(username, password);
		if(!user.isPresent()){
			throw new BadCredentialsException("Tu vieja en tanga para la banda");
		}
		Set<PermissionDTO> authorities = user.get().getRoles().stream()
																				.flatMap(roleDTO -> roleDTO.getPermissions().stream())
																				.collect(Collectors.toSet());
		return new UsernamePasswordAuthenticationToken(user.get(), user.get().getPassword(), authorities);
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}
}
