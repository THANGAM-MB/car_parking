package com.SlotBooking.CarParking.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.SlotBooking.CarParking.Entity.BillDetails;
import com.SlotBooking.CarParking.Entity.BookingDetails;
import com.SlotBooking.CarParking.Entity.CancellationDetails;
import com.SlotBooking.CarParking.Entity.DiscountDetails;
import com.SlotBooking.CarParking.Entity.UsersDetails;
import com.SlotBooking.CarParking.Entity.Festival;
import com.SlotBooking.CarParking.Entity.LocationDetails;
import com.SlotBooking.CarParking.Entity.OwnerDetails;
import com.SlotBooking.CarParking.Entity.SlotDetails;
import com.SlotBooking.CarParking.Entity.VehicleDetails;
import com.SlotBooking.CarParking.POJO.UserLoginPojo;

@Service
public interface MyService {
	
	Festival festivalSave(Festival festival);
	
	public List<Festival> getFestivals();

//*************UserDetails***************
	String userDetailsSave(UsersDetails details);
	
	List<UsersDetails> showUserDetails();
	
	//void createUserDetails(UserDetails userDetails);
 
	String loginUserDetails(UserLoginPojo details);

//************LocationDetails**************
	LocationDetails locationDetailsSave (LocationDetails details);
	
	List<LocationDetails> showLocationDetails ();


//*************OwnerDetails************************
    String ownerDetailsSave(OwnerDetails details);
    
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

       List<BillDetails> updateBillDetails(BillDetails details) ;

	//BillDetails newBillDetails(Map<String, Object> payload);

}
