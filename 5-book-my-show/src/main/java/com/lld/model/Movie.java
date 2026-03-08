package com.lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

@Getter
@AllArgsConstructor
public class Movie {
    private int id;
    private String title;
    private Duration duration;
    private String language;
}
