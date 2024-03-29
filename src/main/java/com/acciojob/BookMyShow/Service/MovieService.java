package com.acciojob.BookMyShow.Service;

import com.acciojob.BookMyShow.Repository.MovieRepository;
import com.acciojob.BookMyShow.models.Movie;
import com.acciojob.BookMyShow.updateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MovieService {


    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(Movie movie)
    {
        movie = movieRepository.save(movie);
        return "The movie has been saved to the db with movieID "+movie.getMovieId();
    }

    public String updateMovie(updateMovieRequest updateMovieRequest)
    {
        Movie movie = movieRepository.findById(updateMovieRequest.getMovieId()).get();

        double rating = updateMovieRequest.getRating();
        double duration = updateMovieRequest.getDuration();

        movie.setDuration(duration);
        movie.setRating(rating);

        movieRepository.save(movie);

        return "Movie attributres are updated successfully.........";
    }
}
