package com.SlotBooking.CarParking.JWTFilter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.SlotBooking.CarParking.Config.CarParkingLogout;
import com.SlotBooking.CarParking.Service.CarParkingCustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@WebFilter
public class CarParkingFilter extends OncePerRequestFilter{
	
	@Autowired
	private CarParkingJWTService carParkingJWTService;
	                                         
	@Autowired 
	private CarParkingLogout carParkingLogout;
	
	@Autowired
	private CarParkingCustomUserDetailsService carParkingCustomUserDetailsService;
	
	public CarParkingFilter() {
		
	}
	
	public CarParkingFilter(CarParkingJWTService carParkingJWTService, CarParkingLogout carParkingLogout) {
		this.carParkingJWTService=carParkingJWTService;
		this.carParkingLogout=carParkingLogout;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("internal filter");
		String authHeader=request.getHeader("Authorization");
		String token = null;
		String email = null;
		CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		if (csrfToken != null) {
            logger.info("CSRF Token Value: " + csrfToken.getToken());
            logger.info("CSRF Token Header Name: " + csrfToken.getHeaderName());
            logger.info("CSRF Token Parameter Name: " + csrfToken.getParameterName());
        }

        // Log CSRF Token from the session (if available)
        CsrfToken sessionCsrfToken = new HttpSessionCsrfTokenRepository().loadToken(request);
        if (sessionCsrfToken != null) {
            logger.info("CSRF Token from Session: " + sessionCsrfToken.getToken());
        }

		if(authHeader!= null && authHeader.startsWith("Bearer ")) {
			System.out.println("Bearer");

			token=authHeader.substring(7);
			email=carParkingJWTService.extractUsername(token);
		}
		if(email != null && SecurityContextHolder.getContext().getAuthentication()==null
			&& !carParkingLogout.isBlacklisted(token)) {
			System.out.println("SecurityContextHolder");
			UserDetails userDetails=carParkingCustomUserDetailsService.loadUserByUsername(email);
			if(carParkingJWTService.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
				System.out.println("loadUserByUsername");
			}
			
	}		System.out.println("request"+ request);
	System.out.println("response"+ response);
	
	

		filterChain.doFilter(request, response);
	}
	

}


