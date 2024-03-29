package com.acciojob.BookMyShow.Service;

import com.acciojob.BookMyShow.Repository.MovieRepository;
import com.acciojob.BookMyShow.Repository.ShowRepository;
import com.acciojob.BookMyShow.Repository.ShowSeatListRepository;
import com.acciojob.BookMyShow.Repository.TheatreRepository;
import com.acciojob.BookMyShow.Requests.addShowRequest;
import com.acciojob.BookMyShow.Requests.addShowSeatsRequest;
import com.acciojob.BookMyShow.enums.SeatType;
import com.acciojob.BookMyShow.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowSeatListRepository showSeatListRepository;

    public String addShow(addShowRequest addShowRequest)
    {
        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());

         Theatre theatre = theatreRepository.findById(addShowRequest.getTheatreId()).get();

         Show show = Show.builder()
                 .showDate(addShowRequest.getShowDate())
                 .showTime(addShowRequest.getShowTime())
                 .movie(movie)
                 .theatre(theatre)
                 .build();

         showRepository.save(show);

         return "Show has been saved to the db with showId"+show.getShowId()+"for movie "+movie;
    }

    public String addShowSeats(addShowSeatsRequest showSeatsRequest)
    {
        List<ShowSeat> showSeatList = new ArrayList<>();

        Integer showId = showSeatsRequest.getShowId();
        Show show = showRepository.findById(showId).get();

        Theatre theatre = show.getTheatre();
        List<TheatreSeat> theatreSeatList = theatre.getTheatreSeatList();

        for(TheatreSeat theatreSeat : theatreSeatList)
        {

            ShowSeat showSeat = ShowSeat.builder()
                                .seatNo(theatreSeat.getSeatNo())
                                .seatType(theatreSeat.getSeatType())
                                .isAvailable(Boolean.TRUE)
                                .show(show)
                                .build();

            if(theatreSeat.getSeatType().equals(SeatType.CLASSIC))
            {
                showSeat.setPrice(showSeatsRequest.getPriceOfClassic());
            }
            else {
                showSeat.setPrice(showSeatsRequest.getPriceOfPremium());
            }

            showSeatList.add(showSeat);
        }

        showSeatListRepository.saveAll(showSeatList);

        return "Show seats have been generated for the given showId"+showId;
    }
}
