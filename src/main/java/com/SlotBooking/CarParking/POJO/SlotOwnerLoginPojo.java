package com.SlotBooking.CarParking.POJO;

import io.micrometer.common.lang.Nullable;

public class SlotOwnerLoginPojo {
	
    private String ownerEmailId;
    
    private String ownerPassword;

	public String getOwnerEmailId() {
		return ownerEmailId;
	}

	public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerEmailId(String ownerEmailId) {
		this.ownerEmailId = ownerEmailId;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}
    
    

}
