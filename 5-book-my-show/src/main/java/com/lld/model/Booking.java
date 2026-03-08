package com.lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Booking {
    private int id;
    private BookingStatus bookingStatus;
    private Show show;
    private Payment payment;
    private List<Seat> seats;
}
