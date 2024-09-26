package com.SlotBooking.CarParking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@SpringBootApplication
@ComponentScan({"com.SlotBooking.CarParking.Entity"})
public class CarParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarParkingApplication.class, args);
	}

}
