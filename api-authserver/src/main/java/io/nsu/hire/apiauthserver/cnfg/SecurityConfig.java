/*
package io.nsu.hire.apiauthserver.cnfg;

import com.google.common.collect.ImmutableList;
import io.nsu.hire.apiauthserver.security.CustomAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Order(-1)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	Logger log = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;


	@Override
	@Bean(name = "authenticationManagerBean")
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(this.customAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.exceptionHandling()
				//.authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/login", "/oauth/token", "/oauth/authorize").permitAll()
				.antMatchers("/api/**").authenticated()
				.and()
				.httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(this.customAuthenticationProvider);
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(ImmutableList.of("*"));
		configuration.setAllowedMethods(ImmutableList.of("HEAD",
				"GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Content-Type"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	*/
/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable()
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/oauth/token", "/oauth/authorize", "/login").permitAll();
	}

	*//*




}
*/
