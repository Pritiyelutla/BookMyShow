package com.acciojob.BookMyShow.Requests;

import com.acciojob.BookMyShow.models.ShowSeat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data

public class bookTicketRequest {

    private String movieName;
    private LocalDate Showdate;
    private LocalTime Showtime;
    private List<String> seatNos;
    private Integer theatreId;
    private String mobNo;
}
