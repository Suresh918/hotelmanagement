package com.booking.hotelmanagement.hotel.service;

import com.booking.hotelmanagement.exception.UnauthorizedException;
import com.booking.hotelmanagement.hotel.repository.HotelRepository;
import com.booking.hotelmanagement.model.Address;
import com.booking.hotelmanagement.model.Hotel;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    // private RoomRepository roomRepository;

    @PreAuthorize("hasRole('SERVICE')")
    @Cacheable("hotels")
    public List<Hotel> getHotels() {
        return this.hotelRepository.findAll();
    }

    @Cacheable(key = "#hotelID", value = "Hotel", unless = "#result.id%2==0")
    public Optional<Hotel> getHotelById(long hotelID) {
        return this.hotelRepository.findById(hotelID);
    }
}
