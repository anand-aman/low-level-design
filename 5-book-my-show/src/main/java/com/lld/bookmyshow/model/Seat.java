package com.lld.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Seat {
    private int id;
    private SeatType seatType;
}
