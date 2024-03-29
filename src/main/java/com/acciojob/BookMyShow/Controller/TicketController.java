package com.acciojob.BookMyShow.Controller;

import com.acciojob.BookMyShow.Requests.bookTicketRequest;
import com.acciojob.BookMyShow.Service.TicketService;
import com.acciojob.BookMyShow.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")

public class TicketController {

    @Autowired
    private TicketService ticketService;
    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket(@RequestBody bookTicketRequest bookTicketRequest)
    {
        try {
        Ticket ticket = ticketService.bookTicket(bookTicketRequest);
        return new ResponseEntity(ticket,HttpStatus.OK);
        }
        catch (Exception e)
        {
               String errormsg = "Error while booking your tickets"+e.getMessage();
               return new ResponseEntity<>(errormsg, HttpStatus.BAD_REQUEST);
        }
    }
}
