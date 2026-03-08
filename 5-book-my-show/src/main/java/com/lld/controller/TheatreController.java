package com.lld.controller;

import com.lld.model.Location;
import com.lld.model.Movie;
import com.lld.model.Show;
import com.lld.model.Theatre;
import com.lld.service.TheatreService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TheatreController {
    private TheatreService theatreService;

    public void addTheatre(final Theatre theatre){

    }

    public List<Show> getShows(Movie movie, LocalDate date, Theatre theatre){
        return new ArrayList<>();
    }

    public List<Movie> getMovies(Location location, LocalDate localDate){
        return new ArrayList<>();
    }
}
