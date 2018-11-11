package narif.pocs.coolspablog.configs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and()
		.httpBasic()
		.and()
		.
		//.anyRequest().authenticated();
		.antMatchers("/api").permitAll();
		super.configure(http);
	}*/
	
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.cors()
 		.and()
 		.authorizeRequests()
 		.antMatchers("/user","/login","/j_spring_security_logout")
 		.permitAll()
 		.antMatchers("/**")
 		.hasRole("USER")
 		.and()
 		.formLogin()
 		.and()
 		.httpBasic()
 		.and()
 		.logout()
 		.logoutUrl("/j_spring_security_logout")
 		.logoutSuccessUrl("/user")
// 		.addLogoutHandler(new LogoutHandler() {
//			
//			@Override
//			public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//				// TODO Auto-generated method stub
//				
//			}
//		})
 		.logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
 		    httpServletResponse.setStatus(HttpServletResponse.SC_OK);
 		})
 		.invalidateHttpSession(true);
 	}

 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		UserDetails user = User.withUsername("user").password("{noop}password").roles("USER").build();
// 		auth.inMemoryAuthentication()
// 		.withUser("user")
// 		.password("password")
// 		.authorities("USER");
 		auth.inMemoryAuthentication()
 		.withUser(user);
 	}

	
	

}
