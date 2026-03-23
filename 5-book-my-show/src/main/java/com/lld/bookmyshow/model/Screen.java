package com.lld.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Screen {
    private int id;
    private Long seatCapacity;
    private List<Seat> seats;
    private Map<LocalDate, Show> showsByDate;
}
