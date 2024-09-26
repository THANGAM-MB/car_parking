package com.SlotBooking.CarParking.Entity;


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
@Table(name = "slot_details")
@AllArgsConstructor
public class SlotDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private Long slotId;
    
    @Column(name="slot_no")
    private String slotNo;
    
    @Column(name="street_name")
    private String streetName; 

    @ManyToOne
    @JoinColumn(name = "loaction_id", nullable = false)
    private LocationDetails locationId;

    @ManyToOne
    @JoinColumn(name = "OwnerId", nullable = false)
    private OwnerDetails owner;

    @Column(name = "slotsize")
    private String slotSize;
    
    @Column(name="amount_per_hour")
    private Double amountPerHour;
    
    

	public Long getSlotId() {
		return slotId;
	}

	public LocationDetails getLocationId() {
		return locationId;
	}

	public OwnerDetails getOwner() {
		return owner;
	}

	public String getSlotSize() {
		return slotSize;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public void setLocationId(LocationDetails locationId) {
		this.locationId = locationId;
	}

	public void setOwner(OwnerDetails owner) {
		this.owner = owner;
	}

	public void setSlotSize(String slotSize) {
		this.slotSize = slotSize;
	}

	public Double getAmountPerHour() {
		return amountPerHour;
	}

	public void setAmountPerHour(Double amountPerHour) {
		this.amountPerHour = amountPerHour;
	}

	public String getSlotNo() {
		return slotNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
    

}
