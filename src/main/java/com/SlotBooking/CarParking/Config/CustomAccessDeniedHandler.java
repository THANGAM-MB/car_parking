package com.SlotBooking.CarParking.Config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Check if the exception is related to CSRF token
        if (accessDeniedException instanceof CsrfException) {
            // Handle CSRF token-related error
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF Token");
        } else {
            // Handle other access denied scenarios
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
        }
    }

	


}
