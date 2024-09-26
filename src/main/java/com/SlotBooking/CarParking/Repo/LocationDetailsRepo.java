package com.SlotBooking.CarParking.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SlotBooking.CarParking.Entity.LocationDetails;

@Repository
public interface LocationDetailsRepo extends JpaRepository<LocationDetails,Long>{

}
