package com.SlotBooking.CarParking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "owner_details")
@AllArgsConstructor
public class OwnerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "name")
    private String name;

    @Column(name = "aadhar_no")
    private String aadharNo;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name="owner_name")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Transient
    private String confirmPassword;
    
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

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
 
    
}
    
    