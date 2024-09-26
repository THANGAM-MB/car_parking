package com.SlotBooking.CarParking.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.SlotBooking.CarParking.Entity.UsersDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UsersDetails, Long>{

	UsersDetails findByEmailId(String userEmailId);

}
