package com.SlotBooking.CarParking.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "cancellation_details")
@AllArgsConstructor
public class CancellationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancellation_id")
    private Long cancellationId;

    @Column(name = "current_date_time")
    private LocalDateTime currentDateTime;

    @ManyToOne
    @JoinColumn(name = "booking_id",nullable =false)
    private BookingDetails bookingId;

    @Column(name = "cancellation_charge")
    private Double cancellationCharge;

	public Long getCancellationId() {
		return cancellationId;
	}

	public LocalDateTime getCurrentDateTime() {
		return currentDateTime;
	}

	public BookingDetails getBookingId() {
		return bookingId;
	}

	public Double getCancellationCharge() {
		return cancellationCharge;
	}

	public void setCancellationId(Long cancellationId) {
		this.cancellationId = cancellationId;
	}

	public void setCurrentDateTime(LocalDateTime localDateTime) {
		this.currentDateTime = localDateTime;
	}

	public void setBookingId(BookingDetails bookingId) {
		this.bookingId = bookingId;
	}

	public void setCancellationCharge(Double cancellationCharge) {
		this.cancellationCharge = cancellationCharge;
	}

    
    
}
