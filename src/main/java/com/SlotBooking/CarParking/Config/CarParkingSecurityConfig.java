package com.SlotBooking.CarParking.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import com.SlotBooking.CarParking.Entity.UsersDetails;
import com.SlotBooking.CarParking.JWTFilter.CarParkingFilter;
import com.SlotBooking.CarParking.JWTFilter.CarParkingJWTService;
import com.SlotBooking.CarParking.Service.CarParkingCustomSuccessHandler;
import com.SlotBooking.CarParking.Service.CarParkingCustomUserDetailsService;
import com.SlotBooking.CarParking.Service.CarParkingCustomUserService;

import ch.qos.logback.classic.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableWebMvc
public class CarParkingSecurityConfig {
	

	@Autowired
	private CarParkingCustomSuccessHandler carParkingCustomSuccessHandler;	
	@Autowired
	private CarParkingCustomUserDetailsService carParkingCustomUserDetailsService;
	
	private CarParkingCustomUserService carParkingCustomUserService;
	
	@Autowired
	private CarParkingLogout CarParkingLogout;
	
	@Autowired
	private CarParkingJWTService carParkingJWTService;
	
	@Autowired
	private CarParkingFilter carParkingFilter;
	
	@Autowired
	private UsersDetails users;

	@Autowired
	private UnAuthorizedHandler unauthorizeHandler;

    @Bean
    public static UserDetailsService userDetailsService() {
		return new CarParkingCustomUserDetailsService();
	}
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.
//				csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).disable())
				csrf(AbstractHttpConfigurer::disable)
			    .cors(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((a)->a
				.requestMatchers("/api/carparkingproject/sec","/api/carparkingproject/UserDetails").permitAll()
                .requestMatchers("/generateToken", "/api/project/showUserDetails", "/api/project/security").permitAll()
                .requestMatchers("/login", "/loginn", "/details").permitAll()
                .requestMatchers("/admin").hasAuthority("ADMIN")
                .requestMatchers("/user").hasAuthority("USER")
                .requestMatchers("/logout").permitAll()
                .anyRequest().authenticated())
               .exceptionHandling()
                .authenticationEntryPoint(unauthorizeHandler)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .and()
                .anonymous((a) -> a
                        .authorities("/api/carparkingproject/UserDetails"))
                .formLogin(form -> form.successHandler(carParkingCustomSuccessHandler).permitAll())
                .exceptionHandling(handling -> handling
                        .defaultAuthenticationEntryPointFor(
                                customAuthenticationEntryPoint(),
                                new AntPathRequestMatcher("/api/carparkingproject/UserDetails")))
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(carParkingFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/loginn"))
                        .logoutSuccessUrl("/login?logout")
                        .deleteCookies("JSESSIONID"))
                .build();
		
		
	} 

	
	@Bean
	public AuthenticationProvider authenticationProvider() throws Exception {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	

	@SuppressWarnings("serial")
	public class AuthenticationFailedException extends RuntimeException {
	    public AuthenticationFailedException(String message) {
	        super(message);
	    }
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(carParkingCustomUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new BasicAuthenticationEntryPoint();
    }
	@Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
	
}
















//@Configuration
//@EnableWebSecurity
//public class CarParkingSecurityConfig extends WebSecurityConfigurerAdapter{
//	@Autowired
//	private CarParkingCustomUserService userService;
//	
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(userService);
//		auth.
//		}
//
//}
