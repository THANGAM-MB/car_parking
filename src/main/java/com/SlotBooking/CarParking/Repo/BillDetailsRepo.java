package com.SlotBooking.CarParking.Repo;



import java.util.Map;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.SlotBooking.CarParking.Entity.BillDetails;

public interface BillDetailsRepo extends JpaRepositoryImplementation<BillDetails, Long> {

	BillDetails save(Map<String, Object> payload);
	


	





}
