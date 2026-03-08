package com.lld.controller;

import com.lld.model.Booking;
import com.lld.model.Seat;
import com.lld.model.Show;
import com.lld.service.BookingService;

import java.util.List;

public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void createBooking(Show show, List<Seat> seats){

    }

    public void cancelBooking(Booking booking){

    }


}
