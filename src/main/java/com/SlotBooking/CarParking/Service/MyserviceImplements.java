package com.SlotBooking.CarParking.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SlotBooking.CarParking.DAO.DAO;
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
import com.SlotBooking.CarParking.Repo.BillDetailsRepo;
import com.SlotBooking.CarParking.Repo.BookingDetailsRepo;
import com.SlotBooking.CarParking.Repo.CancellationDetailsRepo;
import com.SlotBooking.CarParking.Repo.DiscountDetailsRepo;
import com.SlotBooking.CarParking.Repo.UserDetailsRepo;
import com.SlotBooking.CarParking.Repo.FestivalRepo;
import com.SlotBooking.CarParking.Repo.LocationDetailsRepo;
import com.SlotBooking.CarParking.Repo.OwnerDetailsRepo;
import com.SlotBooking.CarParking.Repo.SlotDetailsRepo;
import com.SlotBooking.CarParking.Repo.VehicleDetailsRepo;

@Service
public class MyserviceImplements implements MyService {
	
	@Autowired
	private DAO dao;
	@Autowired
	private FestivalRepo festivalRepo;
	@Autowired
	private UserDetailsRepo userDetailsRepo;
	@Autowired
	private LocationDetailsRepo locationDetailsRepo;
	@Autowired
	private OwnerDetailsRepo ownerDetailsRepo;
	@Autowired
	private DiscountDetailsRepo discountDetailsRepo;
	@Autowired
	private VehicleDetailsRepo vehicleDetailsRepo;
	@Autowired
	private SlotDetailsRepo slotDetailsRepo;
	@Autowired
	private BillDetailsRepo billDetailsRepo;
	@Autowired
	private BookingDetailsRepo bookingDetailsRepo;
	@Autowired
	private CancellationDetailsRepo cancellationDetailsRepo;

	
	
	@Override
	public Festival festivalSave(Festival festival) {
		return dao.festivalSave(festival);
	}
	@Override
	public List<Festival> getFestivals(){
		return dao.getFestivals();	}
	
	//*************UserDetails***************
	
	private UserLoginPojo userLoginPojo;
	
//	@Override
//	public void createUserDetails(UserDetails userDetails) {
//		UserDetails userDetail=UserDetails.builder()
//				.firstname(userDetails.getFirstName())
//		        .lastname(userDetails.getLastName())
//		        .userDetails
//	}

	
	@Override
	public String userDetailsSave(UsersDetails details) {
		String a="";
		if(details.getPassword().equals(details.getConfirmPassword())) {
			 dao.userDetailsSave(details);
			 }
		else {
			a="Password doesn't match";
		}
		return a;
	}

	@Override
	public List<UsersDetails> showUserDetails() {
		return dao.showUserDetails();
	}
	
	@Override
	public 	String loginUserDetails(UserLoginPojo details) {
		Optional<UsersDetails> userDetails=Optional.of(userDetailsRepo.findByEmailId(details.getUserEmailId()));
		if(userDetails.get().getEmailId().equals(details.getUserEmailId()))
		
		{System.out.println(details.getUserPassword());
		System.out.println(userDetails.get().getPassword());
			if (userDetails.get().getPassword().equals(details.getUserPassword())) {
				return "Login Success";
				
			}
			else {
				return "Incorrect Password";
			}
		}
		else
			{
               return"Invalid UserId";
			}
		
	}

	
	//************LocationDetails**************
	@Override
	public LocationDetails locationDetailsSave(LocationDetails details) {
			return dao.locationDetailsSave(details);
		}
	
	@Override
	public List<LocationDetails> showLocationDetails() {
		return dao.showLocationDetails();
	}
	//*************OwnerDetails************************
    
	
	@Override 
	public String ownerDetailsSave(OwnerDetails details) {
		String a="";
		if(details.getPassword().equals(details.getConfirmPassword())) 
		{
			dao.ownerDetailsSave(details);
		}
		else {
			a="Password doesn't match";
		}
		return a;
	}
	
	@Override
	public List<OwnerDetails> showOwnerDetails() {
		return ownerDetailsRepo.findAll();
	}
	
    
    //************VehicleDetails*********************
    
	@Override
	public VehicleDetails vehicleDetailsSave(VehicleDetails details) {
		return dao.vehicleDetailsSave(details);
	}
	
	@Override
	public List<VehicleDetails> showVehicleDetails() {
		return dao.showVehicleDetails();
	}
	  //************SlotDetails*********************

	@Override
	public SlotDetails slotDetailsSave(SlotDetails details) {
		return dao.slotDetailsSave(details);
	}
	
	@Override
	public List<SlotDetails> showSlotDetails() {
		return dao.showSlotDetails();
	}
	
	//***********BookingDetails*******************
	@Override
	public BookingDetails bookingDetailsSave(BookingDetails details){
		return dao.bookingDetailsSave(details);
	}
	
	@Override
	public List<BookingDetails> showBookingDetails() {
		return dao.showBookingDetails();
	}
	
	//***********CancellationDetails*******************

	@Override
	public CancellationDetails cancellationDetailsSave(CancellationDetails details) {
		return dao.cancellationDetailsSave(details);
	}
	
	@Override
	public List<CancellationDetails> showCancellationDetails() {
		return dao.showCancellationDetails();
	}
	
	//***********DiscountDetails*******************

	
	@Override
	public DiscountDetails discountDetailsSave(DiscountDetails details) {
		
		return dao.discountDetailsSave(details);
	}
	
	@Override
	public List<DiscountDetails> showDiscountDetails() {
		return dao.showDiscountDetails();
	}
	
	//***********BillDetails*******************

	@Override
	public BillDetails billDetailsSave(BillDetails details) {
		return dao.billDetailsSave(details);
	}
	@Override
	public List<BillDetails> showBillDetails() {
		return dao.showBillDetails();
	}
//	@Override
//	public BillDetails newBillDetails(Map<String, Object> payload) {
//		return billDetailsRepo.save(payload); 
//	}
	
	@Override
	public List<BillDetails> updateBillDetails(BillDetails details) {
  	  
		Integer percentage=0;
        
        List<BillDetails> billdetails=billDetailsRepo.findAll();
        
        List<DiscountDetails> discount=discountDetailsRepo.findAll();
        
        List<CancellationDetails> cancel=cancellationDetailsRepo.findAll();
        
        String newOfferName="Null";
        
        for (BillDetails bill:billdetails) {
        	for(CancellationDetails cancellation:cancel) {
        		if(cancellationDetailsRepo.existsByBookingId(bill.getBookingId())) {
        		cancellation.setCancellationCharge(100.00);
        		cancellation.setCurrentDateTime(LocalDateTime.now());
        		cancellationDetailsRepo.save(cancellation);
        		bill.setAmountToBePaid(cancellation.getCancellationCharge());
        		billDetailsRepo.save(bill);
                }
        	else {
        	       	
        	//no of days update
        	LocalDate startDate=bill.getBookingId().getStartDateForBooking();
        	LocalDate endDate=bill.getBookingId().getEndDateOfBooking();
        	Period dateDiff=Period.between(startDate, endDate);
        	bill.setNoOfDays(dateDiff.getDays());
        	//total time 
        	LocalTime start=bill.getBookingId().getStartTimeForBooking();
        	LocalTime end=bill.getBookingId().getEndTime();
        	LocalDateTime startTime=LocalDateTime.of(startDate, start);
        	LocalDateTime endTime=LocalDateTime.of(endDate, end);
            Duration duration =Duration.between(startTime,endTime); 
            Double time =(double) duration.toSeconds();
            bill.setTotalTime(time/3600);
            
            //update amountPerHour
            bill.setAmountPerHour(bill.getBookingId().getSlotId().getAmountPerHour());
            
            //update totalamount
            bill.setTotalAmount(bill.getAmountPerHour()*bill.getTotalTime());
            
            //update discountId
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = bill.getBookingId().getVehicleId().getDriverDetails().getDateOfBirth();
        	Period period = Period.between(birthDate, currentDate);
        	System.out.println(currentDate);
        	System.out.println(birthDate);
        	System.out.println(period.getYears());
        
        	if(bill.getBookingId().getVehicleId().getDriverDetails().isExArmy()==true) {
        		newOfferName="Ex_Army";
        		System.out.println(newOfferName);
        		System.out.println(bill.getBookingId().toString()+""+newOfferName);
        	}
        	else if(bill.getBookingId().getVehicleId().getDriverDetails().isStudent()==true) {
        		newOfferName="Student";
        		System.out.println(newOfferName);
        		System.out.println(bill.getBookingId()+""+newOfferName);
        	}
        	
        	else if(period.getYears()>=60) {
        		newOfferName="SeniorCitizon";
        		System.out.println(newOfferName);
        		System.out.println(bill.getBookingId()+""+newOfferName);
        	}
        	else if(festivalRepo.existsByFestivalDate(bill.getBookingId().getStartDateForBooking())) {
        		newOfferName="Festival";
        		System.out.println(newOfferName);
        		System.out.println(bill.getBookingId()+""+newOfferName);
        	}
        	 for(DiscountDetails dis:discount) {
        		 if(dis.getDiscountOffers().equalsIgnoreCase(newOfferName)) {
        			System.out.println(newOfferName);
        			percentage=dis.getDiscountPercentage();
              		bill.setDiscount(dis.getDiscountId());
              		break;
        		 }
             }
        	 //update amountToBePaid
       		bill.setAmountToBePaid(bill.getTotalAmount()-(bill.getTotalAmount()*(percentage/100.00)));
        	 
        	 billDetailsRepo.save(bill) ;
        }
        
	}
	}
        return billdetails;
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	




