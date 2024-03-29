package com.acciojob.BookMyShow.Controller;

import com.acciojob.BookMyShow.Service.MovieService;
import com.acciojob.BookMyShow.models.Movie;
import com.acciojob.BookMyShow.updateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")

public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public String addMovie(@RequestBody Movie movie)
    {
        return movieService.addMovie(movie);
    }

    @PostMapping("/updateMovie")
    public String updateMovie(@RequestBody updateMovieRequest updateMovieRequest){

        return movieService.updateMovie(updateMovieRequest);
    }

}
