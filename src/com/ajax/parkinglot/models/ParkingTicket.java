package com.ajax.parkinglot.models;

import com.ajax.parkinglot.models.sections.ParkingLot;

public class ParkingTicket {
   private String ticketNo;
   private String barCode;
   private String ticketId;
   private ParkingLot parkingLot;

    public ParkingTicket(String ticketNo, String barCode, String ticketId, ParkingLot parkingLot) {
        this.ticketNo = ticketNo;
        this.barCode = barCode;
        this.ticketId = ticketId;
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String toString() {
        return "[ " + ticketId + "\n" + ticketNo + "\n" + barCode +"\n\t" + parkingLot + "]";
    }
}
