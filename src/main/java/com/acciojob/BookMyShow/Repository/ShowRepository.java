package com.acciojob.BookMyShow.Repository;

import com.acciojob.BookMyShow.models.Movie;
import com.acciojob.BookMyShow.models.Show;
import com.acciojob.BookMyShow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<Show, Integer> {

    public Show findShowByShowDateAndShowTimeAndMovieAndTheatre(
            LocalDate showDate,
            LocalTime showTime,
            Movie movie,
            Theatre theatre
    );
}
