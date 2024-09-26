package com.SlotBooking.CarParking.Config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;


@Component
public class CarParkingLogout {
	private Set<String> blacklist = new HashSet<>();

    public void addToBlacklist(String token) {
        blacklist.add(token);
    }

    public boolean isBlacklisted(String token) {
        return blacklist.contains(token);
    }
}


