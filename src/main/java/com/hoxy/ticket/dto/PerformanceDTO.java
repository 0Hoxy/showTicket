package com.hoxy.ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceDTO {

    private String showName;

    private String place;

    private int runTime;

    private LocalDate startDay;

    private LocalDate endDay;

    private int price;
}
