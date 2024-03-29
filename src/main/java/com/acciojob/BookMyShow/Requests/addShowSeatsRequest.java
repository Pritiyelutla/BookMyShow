package com.acciojob.BookMyShow.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class addShowSeatsRequest {


     private Integer showId;
     private Integer priceOfClassic;
     private Integer priceOfPremium;
}
