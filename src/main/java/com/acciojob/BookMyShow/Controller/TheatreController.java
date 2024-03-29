package com.acciojob.BookMyShow.Controller;

import com.acciojob.BookMyShow.Requests.addSeatRequest;
import com.acciojob.BookMyShow.Requests.addTheatreRequests;
import com.acciojob.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/addTheatre")
    public String addTheater(@RequestBody addTheatreRequests addTheatreRequests)
    {
        return theatreService.addTheatre(addTheatreRequests);
    }

    @PostMapping("/addSeats")
    public String addSeats(@RequestBody addSeatRequest addSeatRequest)
    {

        return theatreService.addSeats(addSeatRequest);
    }



}
