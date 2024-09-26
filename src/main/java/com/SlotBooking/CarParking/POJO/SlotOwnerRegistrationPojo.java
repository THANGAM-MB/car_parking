package com.SlotBooking.CarParking.POJO;

import io.micrometer.common.lang.Nullable;

public class SlotOwnerRegistrationPojo {
	
	
	private Long ownerId;

    private String name;

    private String aadharNo;

    private String phoneNo;

	public Long getOwnerId() {
		return ownerId;
	}

	public String getName() {
		return name;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
    
    

}
