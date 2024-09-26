package com.SlotBooking.CarParking.Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="user_details")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UsersDetails {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private Long userId;

	    @Column(name = "first_name")
	    private String firstName;
	    
	    @Column(name="last_name")
	    private String lastName;
	    
	    @Column(name="email_id")
	    private String emailId;
	    
	    @Column(name="password")
	    private String password;
	    
	    @Transient
	    private String confirmPassword;
	    
	    @Column(name = "date_of_birth")
	    private LocalDate dateOfBirth;

	    @Column(name = "occupation")
	    private String occupation;

	    @Column(name = "aadhar", unique = true)
	    private String aadhar;

	    @Column(name = "phone_no_1")
	    private String phoneNo1;

	    @Column(name = "phone_no_2")
	    private String phoneNo2;

	    @Column(name = "license_no", nullable = false)
	    private String licenseNo;

	    @Column(name = "is_ex_army")
	    private boolean isExArmy;

	    @Column(name = "is_student")
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

		public String getConfirmPassword() {
			return confirmPassword;
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

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
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
