package com.SlotBooking.CarParking.Entity;

import java.time.Duration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bill_details")
public class BillDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    @Column(name = "no_of_days")
    private Integer noOfDays;

    @Column(name = "total_time")
    private Double totalTime;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private BookingDetails bookingId;

  
    @Column(name = "discount_id")
    private Long discountId;

    @Column(name = "amount_per_hour")
    private Double amountPerHour;

    @Column(name = "total_amount")
    private Double totalAmount;
    
    @Column(name="amount_to_be_paid")
    private Double amountToBePaid;
    
    @Column(name="is_active")
    private Boolean isActive;
    
    

	public Long getBillId() {
		return billId;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public Double getTotalTime() {
		return totalTime;
	}

	public BookingDetails getBookingId() {
		return bookingId;
	}

	public Long getDiscount() {
		return discountId;
	}

	public Double getAmountPerHour() {
		return amountPerHour;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public void setTotalTime(Double totalTime2) {
		this.totalTime = totalTime2;
	}

	public void setBookingId(BookingDetails bookingId) {
		this.bookingId = bookingId;
	}

	public void setDiscount(Long discountId) {
		this.discountId = discountId;
	}

	public void setAmountPerHour(Double amountPerHour) {
		this.amountPerHour = amountPerHour;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getAmountToBePaid() {
		return amountToBePaid;
	}

	public void setAmountToBePaid(Double amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
    
    
}
