package com.SlotBooking.CarParking.Repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SlotBooking.CarParking.Entity.Festival;

@Repository
public interface FestivalRepo extends JpaRepository<Festival,Long>{

	boolean existsByFestivalDate(LocalDate startDateForBooking);


}
