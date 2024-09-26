package com.SlotBooking.CarParking.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CarParkingCustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler  {
	 
//		@Autowired 
//	    private AuditService auditService; 

	@Autowired
	private CookieClearingLogoutHandler cookieClearingLogoutHandler;
	    @Override
	    public void onLogoutSuccess(
	      HttpServletRequest request, 
	      HttpServletResponse response, 
	      Authentication authentication) 
	      throws IOException, ServletException{
	 
	        String refererUrl = request.getHeader("Referer");
	       //  auditService.track("Logout from: " + refererUrl);

	        try {
				super.onLogoutSuccess(request, response, authentication);
				//cookieClearingLogoutHandler.logout(request, response, authentication);
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}


