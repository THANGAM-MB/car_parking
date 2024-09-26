package com.SlotBooking.CarParking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "discount_details")  // You can change "discounts" to the actual table name
@AllArgsConstructor
public class DiscountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="discount_id")
    private Long discountId;
    @Column(name="discount_offers")
    private String discountOffers;
    @Column(name="discount_percentage")
    private Integer discountPercentage;
	public Long getDiscountId() {
		return discountId;
	}
	public String getDiscountOffers() {
		return discountOffers;
	}
	public Integer getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}
	public void setDiscountOffers(String discountOffers) {
		this.discountOffers = discountOffers;
	}
	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
    
    
    
    
}
