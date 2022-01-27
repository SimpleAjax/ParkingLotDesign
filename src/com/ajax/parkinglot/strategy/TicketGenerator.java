package com.ajax.parkinglot.strategy;

import com.ajax.parkinglot.models.ParkingGate;
import com.ajax.parkinglot.models.ParkingTicket;
import com.ajax.parkinglot.models.VehicleInfo;

public interface TicketGenerator {
    ParkingTicket generateTicket(VehicleInfo vehicleInfo, ParkingGate gate);
}
