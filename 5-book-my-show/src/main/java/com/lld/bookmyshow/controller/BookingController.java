package com.lld.bookmyshow.controller;

import com.lld.bookmyshow.model.Booking;
import com.lld.bookmyshow.model.Seat;
import com.lld.bookmyshow.model.Show;
import com.lld.bookmyshow.service.BookingService;

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
