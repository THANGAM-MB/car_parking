package com.SlotBooking.CarParking.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserLoginPojo {
   
    private String userEmailId;
    
    private String userPassword;

	public String getUserEmailId() {
		return userEmailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
    
    
    
    
}
