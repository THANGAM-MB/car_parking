package com.SlotBooking.CarParking.Repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.SlotBooking.CarParking.Entity.DiscountDetails;

public interface DiscountDetailsRepo extends JpaRepositoryImplementation<DiscountDetails,Long>{


	boolean existsByDiscountOffers(String newOfferName);

}
