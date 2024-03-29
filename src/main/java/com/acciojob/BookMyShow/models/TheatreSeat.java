package com.acciojob.BookMyShow.models;

import com.acciojob.BookMyShow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table

@Builder

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class TheatreSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    public Theatre theatre;
}
