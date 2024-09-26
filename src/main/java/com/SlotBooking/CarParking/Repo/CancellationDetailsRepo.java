package com.SlotBooking.CarParking.Repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.SlotBooking.CarParking.Entity.BookingDetails;
import com.SlotBooking.CarParking.Entity.CancellationDetails;

public interface CancellationDetailsRepo extends JpaRepositoryImplementation<CancellationDetails ,Long> {

	boolean existsByBookingId(BookingDetails bookingId);

}
