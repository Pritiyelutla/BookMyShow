package com.acciojob.BookMyShow.Service;

import com.acciojob.BookMyShow.Repository.TheatreRepository;
import com.acciojob.BookMyShow.Repository.TheatreSeatRepository;
import com.acciojob.BookMyShow.Requests.addSeatRequest;
import com.acciojob.BookMyShow.Requests.addTheatreRequests;
import com.acciojob.BookMyShow.enums.SeatType;
import com.acciojob.BookMyShow.models.Theatre;
import com.acciojob.BookMyShow.models.TheatreSeat;
import com.acciojob.BookMyShow.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TheatreService {

    @Autowired
    public TheatreRepository theatreRepository;

    @Autowired
    public TheatreSeatRepository theatreSeatRepository;

    public String addTheatre(addTheatreRequests addTheatreRequests)
    {
     Theatre theatre = Theatre.builder().address(addTheatreRequests.getAddress()).
                                            name(addTheatreRequests.getName()).
                                            noOfScreen(addTheatreRequests.getNoOfScreen()).build();

        theatre = theatreRepository.save(theatre);

        return "The theatre is created with a theatreId "+theatre.getTheatreId();
    }

    public String addSeats(addSeatRequest addSeatRequest)
    {

        int noOfClassicSeats = addSeatRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addSeatRequest.getNoOfPremiumSeats();

        Integer theatreId = addSeatRequest.getTheatreId();
        Theatre theatre = theatreRepository.findById(theatreId).get();

        int classicseatCounter = 1;

        char ch = 'A';
        int row = 1;

        List<TheatreSeat> theatreSeatList = new ArrayList<>();


        while(classicseatCounter <= noOfClassicSeats)
        {
            String seatNo = row + "" + ch ;
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theatre(theatre)
                    .build();

            theatreSeatList.add(theatreSeat);

            ch++;
            if(classicseatCounter% 5 == 0)
            {
                ch = 'A';
                row ++;
            }
            classicseatCounter++;
        }



        int premiumseatCounter = 1;

        ch = 'A';

        if(classicseatCounter%5 != 1)
            row = row + 1;

         while(premiumseatCounter <= noOfPremiumSeats)
        {
            String seatNo = row + "" + ch ;
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM
                    )
                    .theatre(theatre)
                    .build();

            theatreSeatList.add(theatreSeat);

            ch++;
            if(premiumseatCounter%5 == 0)
            {
                ch = 'A';
                row ++;
            }
            premiumseatCounter++;
        }

         theatre.setTheatreSeatList(theatreSeatList);
         theatreRepository.save(theatre);

         theatreSeatRepository.saveAll(theatreSeatList);

         return "Theatre seats have been generated.";
    }
}
