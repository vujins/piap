package library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	// This method is used for override HttpSecurity of the web Application.
	// We can specify our authorization criteria inside this method.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests().anyRequest().permitAll().and().httpBasic().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();

		/*
		 * // starts authorizing configurations .authorizeRequests() // ignore options
		 * method sent by browser // .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		 * // ignore the static files // .antMatchers("/", "/home", "/login",
		 * "/medjugradska", "/index.html", // "/*.bundle.*", "/assets/**").permitAll()
		 * // authenticate all remaining URLS //
		 * .anyRequest().fullyAuthenticated().and() // enabling the basic authentication
		 * .anyRequest().permitAll().and() .httpBasic().and() // configuring the session
		 * as state less. Which means there is // no session in the server
		 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
		 * and() // disabling the CSRF - Cross Site Request Forgery .csrf().disable();
		 * 
		 */
	}
}
