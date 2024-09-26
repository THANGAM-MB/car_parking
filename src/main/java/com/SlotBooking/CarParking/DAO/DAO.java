package com.SlotBooking.CarParking.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.SlotBooking.CarParking.Entity.BillDetails;
import com.SlotBooking.CarParking.Entity.BookingDetails;
import com.SlotBooking.CarParking.Entity.CancellationDetails;
import com.SlotBooking.CarParking.Entity.DiscountDetails;
import com.SlotBooking.CarParking.Entity.Festival;
import com.SlotBooking.CarParking.Entity.LocationDetails;
import com.SlotBooking.CarParking.Entity.OwnerDetails;
import com.SlotBooking.CarParking.Entity.SlotDetails;
import com.SlotBooking.CarParking.Entity.UsersDetails;
import com.SlotBooking.CarParking.Entity.VehicleDetails;

@Repository
public interface DAO {
    Festival festivalSave(Festival festival);
	
	List<Festival> getFestivals();

	//*************UserDetails***************
	UsersDetails userDetailsSave(UsersDetails details);
	
	List<UsersDetails> showUserDetails();


//************LocationDetails**************
	LocationDetails locationDetailsSave (LocationDetails details);
	
	List<LocationDetails> showLocationDetails ();


//*************OwnerDetails************************
    OwnerDetails ownerDetailsSave(OwnerDetails details);
    
    List<OwnerDetails> showOwnerDetails();

    
//************VehicleDetails*********************
    VehicleDetails vehicleDetailsSave(VehicleDetails details);
    
	List<VehicleDetails> showVehicleDetails();


  //************SlotDetails*********************
    SlotDetails slotDetailsSave(SlotDetails details);
    
	List<SlotDetails>  showSlotDetails();


    //***********BookingDetails*******************
   	BookingDetails bookingDetailsSave(BookingDetails details);
   	
	List<BookingDetails> showBookingDetails();


    //***********CancellationDetails*******************
   	CancellationDetails cancellationDetailsSave(CancellationDetails details);
   	
	List<CancellationDetails> showCancellationDetails();

  //*************DiscountDetails************************
   	DiscountDetails discountDetailsSave(DiscountDetails details);
   	
	List<DiscountDetails> showDiscountDetails ();
  //***********BillDetails*******************
  		BillDetails billDetailsSave(BillDetails details);   	

		List<BillDetails> showBillDetails();

	
		
		
		
}
