package com.acciojob.BookMyShow.models;

import com.acciojob.BookMyShow.enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Showseats")

@Data

@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;

    private Boolean isAvailable;

    @JoinColumn
    @ManyToOne
    private Show show;
}
