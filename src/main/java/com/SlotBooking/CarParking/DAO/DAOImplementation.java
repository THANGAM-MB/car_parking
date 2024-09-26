package com.SlotBooking.CarParking.DAO;

import java.util.List;

import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
import com.SlotBooking.CarParking.Repo.BillDetailsRepo;
import com.SlotBooking.CarParking.Repo.BookingDetailsRepo;
import com.SlotBooking.CarParking.Repo.CancellationDetailsRepo;
import com.SlotBooking.CarParking.Repo.DiscountDetailsRepo;
import com.SlotBooking.CarParking.Repo.FestivalRepo;
import com.SlotBooking.CarParking.Repo.LocationDetailsRepo;
import com.SlotBooking.CarParking.Repo.OwnerDetailsRepo;
import com.SlotBooking.CarParking.Repo.SlotDetailsRepo;
import com.SlotBooking.CarParking.Repo.UserDetailsRepo;
import com.SlotBooking.CarParking.Repo.VehicleDetailsRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class DAOImplementation implements DAO{
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private FestivalRepo festivalRepo;
	@Autowired
	private UserDetailsRepo driverDetailsRepo;
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
		return festivalRepo.save(festival);
	}
	@Override
	public List<Festival> getFestivals(){
		return festivalRepo.findAll();	}
	
	//*************UserDetails***************
	@Override
	public UsersDetails userDetailsSave(UsersDetails details) {
		return driverDetailsRepo.save(details);
	}

	@Override
	public List<UsersDetails> showUserDetails() {
		return driverDetailsRepo.findAll();
	}
	//************LocationDetails**************
	@Override
	public LocationDetails locationDetailsSave(LocationDetails details) {
			return locationDetailsRepo.save(details);
		}
	
	@Override
	public List<LocationDetails> showLocationDetails() {
		return locationDetailsRepo.findAll();
	}
	//*************OwnerDetails************************
    
	
	@Override 
	public OwnerDetails ownerDetailsSave(OwnerDetails details) {
		return ownerDetailsRepo.save(details);
	}
	
	@Override
	public List<OwnerDetails> showOwnerDetails() {
		return ownerDetailsRepo.findAll();
	}
	
    
    //************VehicleDetails*********************
    
	@Override
	public VehicleDetails vehicleDetailsSave(VehicleDetails details) {
		return vehicleDetailsRepo.save(details);
	}
	
	@Override
	public List<VehicleDetails> showVehicleDetails() {
		return vehicleDetailsRepo.findAll();
	}
	  //************SlotDetails*********************

	@Override
	public SlotDetails slotDetailsSave(SlotDetails details) {
		return slotDetailsRepo.save(details);
	}
	
	@Override
	public List<SlotDetails> showSlotDetails() {
		return slotDetailsRepo.findAll();
	}
	
	//***********BookingDetails*******************
	@Override
	public BookingDetails bookingDetailsSave(BookingDetails details){
		return bookingDetailsRepo.save(details);
	}
	
	@Override
	public List<BookingDetails> showBookingDetails() {
		return bookingDetailsRepo.findAll();
	}
	
	//***********CancellationDetails*******************

	@Override
	public CancellationDetails cancellationDetailsSave(CancellationDetails details) {
		return cancellationDetailsRepo.save(details);
	}
	
	@Override
	public List<CancellationDetails> showCancellationDetails() {
		return cancellationDetailsRepo.findAll();
	}
	
	//***********DiscountDetails*******************

	
	@Override
	public DiscountDetails discountDetailsSave(DiscountDetails details) {
		
		return discountDetailsRepo.save(details);
	}
	
	@Override
	public List<DiscountDetails> showDiscountDetails() {
		return discountDetailsRepo.findAll();
	}
	
	//***********BillDetails*******************

	@Override
	public BillDetails billDetailsSave(BillDetails details) {
		return billDetailsRepo.save(details);
	}
	@Override
	public List<BillDetails> showBillDetails() {
		return billDetailsRepo.findAll();
	}
	
  

}
