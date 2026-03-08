package com.lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class Show {
    private int id;
    private Movie movie;
    private LocalDate showDate;
    private LocalTime startTime;
}
