package com.booking.hotelmanagement.hotel.controller;

import com.booking.hotelmanagement.exception.EntityIdNotFoundException;
import com.booking.hotelmanagement.hotel.service.HotelDataImportService;
import com.booking.hotelmanagement.hotel.service.HotelService;
import com.booking.hotelmanagement.model.Hotel;
import com.booking.hotelmanagement.room.service.RoomService;
import com.booking.hotelmanagement.security.AuthenticatedContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Data
@RestController
@RequestMapping("/hotel")
@Slf4j
public class HotelController {

    private HotelService hotelService;
    private RoomService roomService;
    private AuthenticatedContext authenticatedContext;
    private HotelDataImportService hotelDataImportService;

    public HotelController(HotelService hotelService, HotelDataImportService hotelDataImportService, RoomService roomService, ObjectMapper objectMapper, AuthenticatedContext authenticatedContext) {
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.authenticatedContext = authenticatedContext;
        this.hotelDataImportService = hotelDataImportService;
    }

    @GetMapping(value = "/search")
    public String getHotels(@RequestParam(value = "state", required = false) String state,
                            @RequestParam(value = "suburb", required = false) String suburb,
                            @RequestParam(value = "postcode", required = false) String postcode,
                            Pageable pageable, Model model) {
        /*Page<Hotel> results = hotelRepository.findAllByLocation(state, suburb, postcode, pageable);
        model.addAttribute("hotels", results == null ? Page.empty() : results);*/
        return "/hotel/hotels";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADMIN')")
    public List<Hotel> getHotels() {
        log.info("Hotel home page");
        log.info("user " + this.authenticatedContext.getUser());
        log.info("user roles" + this.authenticatedContext.getRoles());
        return hotelService.getHotels();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADMIN')")
    public Hotel getHotelByID(@PathVariable("id") long hotelID) throws EntityIdNotFoundException {
        return hotelService.getHotelById(hotelID).orElseThrow(EntityIdNotFoundException::new);
    }

    @GetMapping(value = "/dumpData")
    public String dumpData() {
        log.info("HotelController : dumpData");
        this.hotelDataImportService.dumpData();
        return "data imported successfully";
    }
}
