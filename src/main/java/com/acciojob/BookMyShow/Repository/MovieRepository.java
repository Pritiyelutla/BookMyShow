package com.acciojob.BookMyShow.Repository;

import com.acciojob.BookMyShow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieByMovieName(String movieName);
}
