package com.SlotBooking.CarParking.Config;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UnAuthorizedHandler implements AuthenticationEntryPoint {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UnAuthorizedHandler.class);

    @Override
    public void commence(HttpServletRequest request,
                     HttpServletResponse response,
                     AuthenticationException e) 
                             throws IOException, ServletException {

        logger.error("Unauthorized error. Message - {}", e.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");
} 
}