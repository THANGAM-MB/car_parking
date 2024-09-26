package com.SlotBooking.CarParking.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SlotBooking.CarParking.Config.CarParkingLogout;
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
import com.SlotBooking.CarParking.JWTFilter.CarParkingFilter;
import com.SlotBooking.CarParking.JWTFilter.CarParkingJWTService;
import com.SlotBooking.CarParking.POJO.UserLoginPojo;
import com.SlotBooking.CarParking.Service.CarParkingCustomUserService;
import com.SlotBooking.CarParking.Service.MyService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/carparkingproject")
public class CarParkingController {
	@Autowired
	private MyService myService;
	
	@Autowired
	private UserLoginPojo userLoginPojo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CarParkingCustomUserService userService;
	
	@Autowired
	private CarParkingJWTService carParkingJwtService;
	
	@Autowired
	private CarParkingFilter carParkingFilter;
	
	@Autowired
	private UsersDetails userDetails;
	
	@Autowired
	private CarParkingLogout carParkingLogout;
	
	@GetMapping("/sec")
	public String Hi() {
		System.out.println("Hi");
		return "Hi";
	}
	
	@PostMapping("/Festival")
	public Festival create(@RequestBody Festival festival) {
		return myService.festivalSave(festival);
	
	}
	
	@GetMapping("/showFestival")
	public List<Festival> getFestival() {
		return myService.getFestivals();
	
	}
	//*************UserDetails***************
		@PostMapping("/UserDetails")
			public String createUser(@RequestBody UsersDetails details) {
			System.out.println("User created");	
			return myService.userDetailsSave(details);
			}
		
		@PostMapping("/Registration")
		public String registerUserDetails(@RequestBody UsersDetails details) {
			return myService.userDetailsSave(details);
		}
		@PostMapping("/showUserDetails")
		public List<UsersDetails> showDriverDetails() {
			System.out.println("In showUserDetails");
			System.out.println(myService.showUserDetails());
			return myService.showUserDetails();
			
		}
		
		@PostMapping("loginUserDetails")
		public 	String loginUserDetails(@RequestBody UserLoginPojo details) {
			System.out.println("deatails"+details.getUserEmailId());
			return myService.loginUserDetails(details);
		}

//************LocationDetails**************
		@PostMapping("/LocationDetails")
		public LocationDetails createLocation(LocationDetails details) {
			return myService.locationDetailsSave(details);
		}
		@GetMapping("/showLocationDetails")
		public List<LocationDetails> showLocationDetails() {
			return myService.showLocationDetails();
		}
				
//***************OwnerDetails****************
		@PostMapping("/OwnerDetails")
		public String createOwner(OwnerDetails details) {
			return myService.ownerDetailsSave(details);
		}
		@GetMapping("/showOwnerDetails")
		public List<OwnerDetails> showOwnerDetails() {
			return myService.showOwnerDetails();
		}
		
//************VehicleDetails*****************
		@PostMapping("/VehicleDetails")
		public VehicleDetails createVehicle(VehicleDetails details){
			return myService.vehicleDetailsSave(details);
		}
		
		@GetMapping("/showVehicleDetails")
		public List<VehicleDetails> showVehicleDetails( ){
			return myService.showVehicleDetails();
		}
		
		
//************SlotDetails*********************
		@PostMapping("/SlotDetails")
		public SlotDetails createSlot(SlotDetails details){
			return myService.slotDetailsSave(details);
		}
		
		@GetMapping("/showSlotDetails")
		public List<SlotDetails> showSlotDetails(){
			return myService.showSlotDetails();
		}
		
		
//************BookingDetails*********************
		@PostMapping("/BookingDetails")
		public BookingDetails createBooking(BookingDetails details){
			return myService.bookingDetailsSave(details);
		}
		
		@GetMapping("/showBookingDetails")
		public List<BookingDetails> showBookingDetails(){
			return myService.showBookingDetails();
		}
		
		
//************CancellationDetails*********************
		@PostMapping("/CancellationDetails")
		public CancellationDetails createCancellation(CancellationDetails details){
			return myService.cancellationDetailsSave(details);
		}
		
		@GetMapping("/showCancellationDetails")
		public List<CancellationDetails> showCancellationDetails(){
			return myService.showCancellationDetails();
		}
		
		
//************DiscountDetails*********************
		@PostMapping("/DiscountDetails")
		public DiscountDetails createDiscount(DiscountDetails details){
			return myService.discountDetailsSave(details);
		}	
		
		@GetMapping("/showDiscountDetails")
		public List<DiscountDetails> showDiscountDetails(){
			return myService.showDiscountDetails();
		}
		
//*****************BillDetails*******************
		@PostMapping("/BillDetails")
		public BillDetails createDiscount(BillDetails details){
			return myService.billDetailsSave(details);
		}	
//		@PostMapping("/BillDetails")
//		public BillDetails createDiscount(@RequestBody Map<String,Object> payload){
//			
//			return myService.newBillDetails(payload);
//		}	
		
		@GetMapping("/BillDetails")
		public List<BillDetails> showBillDetails(){
			return myService.showBillDetails();
		}
		@PutMapping("/updateBillDetails")
		public List<BillDetails> updateBillDetails(BillDetails details){
            return myService.updateBillDetails(details);
		}
		
		
		
		String newToken;
		@PostMapping("/login")
		public String login(@RequestBody HttpServletRequest loginRequest, HttpServletResponse response) {
			
			return "login";
		}
		
		@PostMapping("/user")

		public UsersDetails user(String details) throws Exception{
			System.out.println("user");
	        System.out.println("UserNewtoken: "+newToken);
	        String userName=carParkingJwtService.extractUsername(newToken);
			return (UsersDetails) myService.showUserDetails();
			
		}
		
		 @PostMapping("/logout")
		    public ResponseEntity<String> logoutnewToken(@RequestHeader("Authorization") String NewToken) {
			 	System.out.println("In logout");
			 	carParkingLogout.addToBlacklist(NewToken.substring(7)); 
	            System.out.println(NewToken.isEmpty());
		        return ResponseEntity.ok("Logout successful");
		 }
		 
			@PostMapping("/generateToken") 
		    public String authenticateAndGetToken(@RequestBody UserLoginPojo userLoginPojo) throws Exception{ 
				Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginPojo.getUserEmailId(), userLoginPojo.getUserPassword())); 
		        if (authentication.isAuthenticated()) { 
		            newToken=carParkingJwtService.generateToken(userLoginPojo.getUserEmailId()); 
		             System.out.println("Newtoken: "+newToken);
		             Cookie cookie = new Cookie("token", newToken);
		             cookie.setMaxAge(86400); // 1 day in seconds
		             cookie.setHttpOnly(true);
		             cookie.setPath("/");
		             //response.addCookie(cookie);
		     		//return "login";
		             System.out.println("cookie:"+cookie);
		             return carParkingJwtService.generateToken(userLoginPojo.getUserEmailId());
		        } else { 
		            throw new UsernameNotFoundException("invalid user request !"); 
		        } 
		    } 
		
		}