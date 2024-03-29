package com.acciojob.BookMyShow.Service;

import com.acciojob.BookMyShow.Exception.SeatsUnavailableException;
import com.acciojob.BookMyShow.Repository.*;
import com.acciojob.BookMyShow.Requests.bookTicketRequest;
import com.acciojob.BookMyShow.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TicketService {

   @Autowired
   private MovieRepository movieRepository;

   @Autowired
   private TheatreRepository theatreRepository;

   @Autowired
   private ShowRepository showRepository;

   @Autowired
   private ShowSeatListRepository showSeatListRepository;

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private TicketRepository ticketRepository;

    public Ticket bookTicket(bookTicketRequest bookTicketRequest) throws Exception
    {

        //1.Calculate the total cost of tickets

        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Theatre theatre = theatreRepository.findById(bookTicketRequest.getTheatreId()).get();

        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheatre(bookTicketRequest.getShowdate(),
                                                                                    bookTicketRequest.getShowtime(),
                                                                                    movie,theatre
        );

        Integer showId = show.getShowId();
        List<ShowSeat> showSeatsList = showSeatListRepository.findAllByShow(show);


        int totalAmt = 0;
        boolean areAllSeatsAvailable = true;
        for(String seatNo : bookTicketRequest.getSeatNos())
        {
            for(ShowSeat showSeat: showSeatsList)
            {
                if(showSeat.getSeatNo().equals(seatNo))
                {
                    if(showSeat.getIsAvailable() == Boolean.FALSE) {
                        areAllSeatsAvailable = false;
                        break;
                    }

                    totalAmt = totalAmt + showSeat.getPrice();
                }
            }
        }

        if(areAllSeatsAvailable == Boolean.FALSE)
        {
            throw new SeatsUnavailableException("The requested seats are unavailable");
        }

        //2.Make the seats booked

        for(String seatNo : bookTicketRequest.getSeatNos())
        {
            for (ShowSeat showSeat : showSeatsList)
            {
                if (showSeat.getSeatNo().equals(seatNo))
                {
                    showSeat.setIsAvailable(Boolean.FALSE);
                }
            }
        }

        String MobNo = bookTicketRequest.getMobNo();

        User user= userRepository.findUserByMobNo(MobNo);

        //3.Save the ticketEntity

        Ticket ticket = Ticket.builder()
                        .user(user)
                        .showDate(bookTicketRequest.getShowdate())
                        .showtime(bookTicketRequest.getShowtime())
                        .movieName(movie.getMovieName())
                        .theatreNameAndAddress(theatre.getName()+" "+theatre.getAddress())
                        .totalAmount(totalAmt)
                        .build();

        ticketRepository.save(ticket);

        //4. generate and return back the actual ticket response

       return ticket;
    }
}