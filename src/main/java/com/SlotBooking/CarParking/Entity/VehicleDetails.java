package com.SlotBooking.CarParking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicle_details")
@AllArgsConstructor
public class VehicleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;
    
    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private UsersDetails driverDetails;
    
    @Column(name = "vehicle_name")
    private String vehicleName;

    @Column(name = "vehicle_no", unique = true, nullable = false)
    private String vehicleNumber;

    @Column(name = "vehicle_model")
    private String vehicleModel;

    @Column(name = "rc_book_no", unique = true, nullable = false)
    private String rcBookNumber;

    @Column(name = "insurance_no", unique = true, nullable = false)
    private String insuranceNumber;

	public Long getVehicleId() {
		return vehicleId;
	}

	public UsersDetails getDriverDetails() {
		return driverDetails;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public String getRcBookNumber() {
		return rcBookNumber;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setDriverDetails(UsersDetails driverDetails) {
		this.driverDetails = driverDetails;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public void setRcBookNumber(String rcBookNumber) {
		this.rcBookNumber = rcBookNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
    






}