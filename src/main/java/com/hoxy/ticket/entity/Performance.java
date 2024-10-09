package com.hoxy.ticket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "performances")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String showName;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private int runTime;

    @Column(nullable = false)
    private LocalDate startDay;

    @Column(nullable = false)
    private LocalDate endDay;

    @Column(nullable = false)
    private int price;
}
