package com.SlotBooking.CarParking.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "booking_details")
@AllArgsConstructor
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "start_date_for_booking")
    private LocalDate startDateForBooking;

    @Column(name = "start_time_for_booking")
    private LocalTime startTimeForBooking;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "end_date_of_booking")
    private LocalDate endDateOfBooking;

    @ManyToOne
    @JoinColumn(name = "slotId", nullable = false)
    private SlotDetails slotId;

    @OneToOne
    @JoinColumn(name = "vechicleId", nullable = false)
    private VehicleDetails vehicleId;

	public Long getBookingId() {
		return bookingId;
	}

	public LocalDate getStartDateForBooking() {
		return startDateForBooking;
	}

	public LocalTime getStartTimeForBooking() {
		return startTimeForBooking;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public LocalDate getEndDateOfBooking() {
		return endDateOfBooking;
	}

	public SlotDetails getSlotId() {
		return slotId;
	}

	public VehicleDetails getVehicleId() {
		return vehicleId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public void setStartDateForBooking(LocalDate startDateForBooking) {
		this.startDateForBooking = startDateForBooking;
	}

	public void setStartTimeForBooking(LocalTime startTimeForBooking) {
		this.startTimeForBooking = startTimeForBooking;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public void setEndDateOfBooking(LocalDate endDateOfBooking) {
		this.endDateOfBooking = endDateOfBooking;
	}

	public void setSlotId(SlotDetails slotId) {
		this.slotId = slotId;
	}

	public void setVehicleId(VehicleDetails vehicleId) {
		this.vehicleId = vehicleId;
	}

	    
}
