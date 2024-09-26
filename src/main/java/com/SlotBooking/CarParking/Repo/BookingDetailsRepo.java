package com.SlotBooking.CarParking.Repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.SlotBooking.CarParking.Entity.BookingDetails;

public interface BookingDetailsRepo extends JpaRepositoryImplementation<BookingDetails, Long> {

}
