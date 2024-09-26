package com.SlotBooking.CarParking.Entity;

import java.time.LocalDate;
import java.util.Date;

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
@Table(name="Festival")
@AllArgsConstructor
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Festival_Id")
    private Long festivalId;

    @Column(name = "festival_name")
    private String festivalName;

    @Column(name = "festival_date")
    private LocalDate festivalDate;
    
    @ManyToOne
    @JoinColumn(name="location_id")
    private LocationDetails locationId;

	public Long getFestivalId() {
		return festivalId;
	}

	public String getFestivalName() {
		return festivalName;
	}

	public LocalDate getFestivalDate() {
		return festivalDate;
	}

	public LocationDetails getLocationId() {
		return locationId;
	}

	public void setFestivalId(Long festivalId) {
		this.festivalId = festivalId;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}

	public void setFestivalDate(LocalDate festivalDate) {
		this.festivalDate = festivalDate;
	}

	public void setLocationId(LocationDetails locationId) {
		this.locationId = locationId;
	}

 
	

	
    
}
    
    
    
    