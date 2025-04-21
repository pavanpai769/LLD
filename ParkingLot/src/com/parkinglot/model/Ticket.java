package com.parkinglot.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    private String ticketId;
    private LocalTime time;
    private LocalDate date;

    public Ticket(String ticketId) {
        this.ticketId = ticketId;
        this.time = LocalTime.now();
        this.date = LocalDate.now();
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public LocalDate getDate() {
        return this.date;
    }
}
