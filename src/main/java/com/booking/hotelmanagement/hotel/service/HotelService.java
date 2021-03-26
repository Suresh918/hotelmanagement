package com.booking.hotelmanagement.hotel.service;

import com.booking.hotelmanagement.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    // private RoomRepository roomRepository;

    @PreAuthorize("hasRole('SERVICE')")
    public String getHotels() {
        return "welcome to Hotel Management";
    }
}
