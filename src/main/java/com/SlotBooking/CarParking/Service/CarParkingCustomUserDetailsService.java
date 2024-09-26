package com.SlotBooking.CarParking.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.SlotBooking.CarParking.Repo.UserDetailsRepo;

@Component
public class CarParkingCustomUserDetailsService implements UserDetailsService {
	
	String newEmail,newPassword,newRole;
	@Autowired
	private UserDetailsRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.SlotBooking.CarParking.Entity.UsersDetails userEntity=userRepo.findByEmailId(email);
//		Optional<UserEntity> userEntity=userRepo.findByEmail(email);
		//newEmail=userEntity.getEmail();
//		String newPassword=userEntity.get().getPassword();
//		String newRole=userEntity.get().getRole();
		if(userEntity==null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CarParkingCustomUserService(userEntity);
	}
	public String getNewEmail() {
		System.out.println("newEmail: "+newEmail);
		return newEmail;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getNewRole() {
		return newRole;
	}
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setNewRole(String newRole) {
		this.newRole = newRole;
	}

}


