package com.acciojob.BookMyShow.Repository;

import com.acciojob.BookMyShow.models.Movie;
import com.acciojob.BookMyShow.models.Show;
import com.acciojob.BookMyShow.models.Theatre;
import com.acciojob.BookMyShow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {


}
