package io.nsu.hire.apigateway.cnfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().and().authorizeRequests().antMatchers(HttpMethod.GET, "/reviews/**").authenticated()
				//.antMatchers(HttpMethod.GET, "/catalog/**").authenticated()
				/**
				 * Configure User server authorizations
				 */
				.antMatchers(HttpMethod.GET, "/api/admin/**").hasAnyAuthority("READ_USERS", "INFO_SERVER")
				.antMatchers(HttpMethod.POST, "/api/admin/**").hasAuthority("CREATE_ADMIN_USER")
				.antMatchers(HttpMethod.PUT, "/api/admin/**").hasAuthority("UPDATE_ADMIN_USER")
				.antMatchers(HttpMethod.DELETE, "/api/admin/**").hasAuthority("DELETE_ADMIN_USER")

				.antMatchers(HttpMethod.GET, "/api/recruiter/**").hasAnyAuthority("GET_RECRUITER_LIST_USER")

				.antMatchers(HttpMethod.GET, "/api/client/**").hasAnyAuthority("GET_CLIENT_LIST_USER")

				.antMatchers("/metrics/**").access("#oauth2.hasScope('metrics')").antMatchers("/trace/**")
				.access("#oauth2.hasScope('trace')").antMatchers("/dump/**").access("#oauth2.hasScope('dump')")
				.antMatchers("/shutdown/**").access("#oauth2.hasScope('shutdown')").antMatchers("/beans/**")
				.access("#oauth2.hasScope('beans')").antMatchers("/autoconfig/**")
				.access("#oauth2.hasScope('autoconfig')").antMatchers("/configprops/**")
				.access("#oauth2.hasScope('configprops')").antMatchers("/env/**").access("#oauth2.hasScope('env')")
				.antMatchers("/mappings/**").access("#oauth2.hasScope('mappings')");

	}
}