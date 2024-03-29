package com.acciojob.BookMyShow.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Shows")

@Builder
@AllArgsConstructor //  for bulider annotation
@NoArgsConstructor

//@Getter
//@Setter
@Data // instead of getter and setter


public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private LocalDate showDate; //YYYY-MM-DD

    private LocalTime showTime; //HH:MM:SS

    @JoinColumn
    @ManyToOne
    private Movie movie;

    @JoinColumn
    @ManyToOne
    private Theatre theatre;
}
