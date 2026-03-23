package com.lld.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Theatre {
    private int id;
    private Location location;
    private List<Screen> screens;
}
