package com.booking.hotelmanagement.hotel.service;

import com.booking.hotelmanagement.hotel.repository.HotelRepository;
import com.booking.hotelmanagement.model.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashSet;

@Service
@NoArgsConstructor
public class HotelDataImportService {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelDataImportService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void dumpData() {
        this.createHotel1();
        this.createHotel2();
        this.createHotel3();
        this.createHotel4();
        this.createHotel5();
        this.createHotel6();
    }

    private void createHotel1() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        Address address = new Address(null, "The Grand Hotel", "166 Albert Road", null,
                State.VIC, "Melbourne", new Postcode("3000"));

        Hotel grandHotel = new Hotel(null, "The Grand Hotel", address, 4, "grandhotel.com.au", null, new HashSet<Room>(),
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room(null, null, "G1", RoomType.Economy, 1, BigDecimal.valueOf(65.12));
        Room room2 = new Room(null, null, "G2", RoomType.Business, 2, BigDecimal.valueOf(105.45));
        Room room3 = new Room(null, null, "G3", RoomType.Luxury, 4, BigDecimal.valueOf(205.66));
        Room room4 = new Room(null, null, "G4", RoomType.Economy, 2, BigDecimal.valueOf(35.40));

        grandHotel.addRoom(room1);
        grandHotel.addRoom(room2);
        grandHotel.addRoom(room3);
        grandHotel.addRoom(room4);

        hotelRepository.save(grandHotel);
    }

    private void createHotel2() {
        LocalTime earliestCheckInTime = LocalTime.of(8, 0);
        LocalTime latestCheckInTime = LocalTime.of(19, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(13, 0);
        LocalTime latestCheckOutTime = LocalTime.of(15, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(29.40);

        Address address2 = new Address(null, "Glen Iris", "99A Glen Road", null,
                State.VIC, "Glen Waverley", new Postcode("3150"));

        Hotel hotel = new Hotel(null, "Glen Iris", address2, 3, "glenhotel.com.au", null, new HashSet<Room>(),
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room(null, null, "H1", RoomType.Economy, 5, BigDecimal.valueOf(85.12));
        Room room2 = new Room(null, null, "H2", RoomType.Business, 2, BigDecimal.valueOf(105.45));
        Room room3 = new Room(null, null, "H3", RoomType.Luxury, 4, BigDecimal.valueOf(205.66));
        Room room4 = new Room(null, null, "H4", RoomType.Economy, 2, BigDecimal.valueOf(35.40));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }

    private void createHotel3() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        Address address = new Address(null, "Cevello Blanca", "2 smith street", null,
                State.VIC, "Carlton", new Postcode("3053"));

        Hotel hotel = new Hotel(null,"Cevello Blanca", address, 5, "cevellohotel.com.au",null, new HashSet<Room>(),
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room(null, null, "C1", RoomType.Economy, 4, BigDecimal.valueOf(65.12));
        Room room2 = new Room(null, null, "C2", RoomType.Business, 4, BigDecimal.valueOf(105.45));
        Room room3 = new Room(null, null, "C3", RoomType.Luxury, 4, BigDecimal.valueOf(205.66));
        Room room4 = new Room(null, null, "C4", RoomType.Economy, 1, BigDecimal.valueOf(35.40));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }

    private void createHotel4() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        Address address = new Address(null, "Bravo", "7 apple avenue", null,
                State.VIC, "Docklands", new Postcode("3008"));

        Hotel hotel = new Hotel(null,"Bravo", address, 2, "bravoohotel.com.au",null, new HashSet<Room>(),
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room(null, null, "B1", RoomType.Economy, 4, BigDecimal.valueOf(35.12));
        Room room2 = new Room(null, null, "B2", RoomType.Business, 5, BigDecimal.valueOf(115.35));
        Room room3 = new Room(null, null, "B3", RoomType.Luxury, 4, BigDecimal.valueOf(215.36));
        Room room4 = new Room(null, null, "B4", RoomType.Economy, 2, BigDecimal.valueOf(135.40));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }

    private void createHotel5() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        Address address = new Address(null, "Zamza", "7 zamza avenue", null,
                State.VIC, "Melbourne", new Postcode("3000"));

        Hotel hotel = new Hotel(null, "Zamza", address, 4, "zamzaohotel.com.au",null, new HashSet<Room>(),
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room(null, null, "Z1", RoomType.Economy, 4, BigDecimal.valueOf(35.12));
        Room room2 = new Room(null, null, "Z2", RoomType.Economy, 5, BigDecimal.valueOf(115.35));
        Room room3 = new Room(null, null, "Z3", RoomType.Luxury, 4, BigDecimal.valueOf(215.36));
        Room room4 = new Room(null, null, "Z4", RoomType.Economy, 2, BigDecimal.valueOf(135.40));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }

    private void createHotel6() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        Address address = new Address(null, "Xavier Hotel", "7 xavier road", null,
                State.VIC, "Melbourne", new Postcode("3000"));

        Hotel hotel = new Hotel(null,"Xavier Hotel", address, 4, "xavierhotel.com.au",null, new HashSet<Room>(),
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room(null, null, "X1", RoomType.Economy, 4, BigDecimal.valueOf(13.12));
        Room room2 = new Room(null, null, "X2", RoomType.Economy, 5, BigDecimal.valueOf(94.35));
        Room room3 = new Room(null, null, "X3", RoomType.Luxury, 4, BigDecimal.valueOf(193.16));
        Room room4 = new Room(null, null, "X4", RoomType.Economy, 2, BigDecimal.valueOf(19.40));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
}
