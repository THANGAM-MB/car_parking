package com.SlotBooking.CarParking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name="location_details")
@AllArgsConstructor
public class LocationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "Country")
    private String country;

    @Column(name = "State")
    private String state;

    @Column(name = "District")
    private String district;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "Pincode")
    private String pincode;

	public Long getLocationId() {
		return locationId;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getDistrict() {
		return district;
	}

	public String getCityName() {
		return cityName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


}
