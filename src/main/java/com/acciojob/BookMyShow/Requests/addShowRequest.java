package com.acciojob.BookMyShow.Requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter

public class addShowRequest {

    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private Integer theatreId;

}
