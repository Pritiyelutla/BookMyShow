package com.acciojob.BookMyShow.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class addSeatRequest {

    private Integer noOfClassicSeats;

    private Integer noOfPremiumSeats;

    private Integer theatreId;
}
