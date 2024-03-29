package com.acciojob.BookMyShow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Tickets")

@Data

@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ticketId;

    private String movieName;

    private LocalDate showDate;

    private LocalTime showtime;

    private String theatreNameAndAddress;

    private Integer totalAmount;

    @JoinColumn
    @ManyToOne
    private  User user;
}
