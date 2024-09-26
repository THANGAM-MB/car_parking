package com.SlotBooking.CarParking.POJO;

import java.time.LocalDate;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;

public class UserRegistrationPojo {
	    
	    private Long userId;

	    private String firstName;
	    
	    private String lastName;
	    
	    private String emailId;
	    
	    private String password;
	    
	    private LocalDate dateOfBirth;

	    private String occupation;

	    private String aadhar;

	    private String phoneNo1;
	    
	    @Nullable
	    private String phoneNo2;

	    private String licenseNo;

	    private boolean isExArmy;

	    private boolean isStudent;

		public Long getUserId() {
			return userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getEmailId() {
			return emailId;
		}

		public String getPassword() {
			return password;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public String getOccupation() {
			return occupation;
		}

		public String getAadhar() {
			return aadhar;
		}

		public String getPhoneNo1() {
			return phoneNo1;
		}

		public String getPhoneNo2() {
			return phoneNo2;
		}

		public String getLicenseNo() {
			return licenseNo;
		}

		public boolean isExArmy() {
			return isExArmy;
		}

		public boolean isStudent() {
			return isStudent;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}

		public void setAadhar(String aadhar) {
			this.aadhar = aadhar;
		}

		public void setPhoneNo1(String phoneNo1) {
			this.phoneNo1 = phoneNo1;
		}

		public void setPhoneNo2(String phoneNo2) {
			this.phoneNo2 = phoneNo2;
		}

		public void setLicenseNo(String licenseNo) {
			this.licenseNo = licenseNo;
		}

		public void setExArmy(boolean isExArmy) {
			this.isExArmy = isExArmy;
		}

		public void setStudent(boolean isStudent) {
			this.isStudent = isStudent;
		}

	    
	    
}
