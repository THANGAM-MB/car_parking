package com.SlotBooking.CarParking.Repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.SlotBooking.CarParking.Entity.SlotDetails;

public interface SlotDetailsRepo extends JpaRepositoryImplementation<SlotDetails, Long> {

}
