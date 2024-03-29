package com.acciojob.BookMyShow.Controller;

import com.acciojob.BookMyShow.Repository.ShowRepository;
import com.acciojob.BookMyShow.Requests.addShowRequest;
import com.acciojob.BookMyShow.Requests.addShowSeatsRequest;
import com.acciojob.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")

public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public String addShow(@RequestBody addShowRequest addShowRequest)
    {
        return showService.addShow(addShowRequest);
    }

    @PostMapping("/addShowSeats")
    public String AddShowRequest(@RequestBody addShowSeatsRequest addShowSeatsRequest)
    {
        return showService.addShowSeats(addShowSeatsRequest);
    }
}
