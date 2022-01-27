package com.ajax.parkinglot;

import com.ajax.parkinglot.enums.GateTypeEnum;
import com.ajax.parkinglot.enums.TicketGeneratorStrategyEnum;
import com.ajax.parkinglot.enums.VehicleTypeEnum;
import com.ajax.parkinglot.models.ParkingGate;
import com.ajax.parkinglot.models.ParkingTicket;
import com.ajax.parkinglot.models.VehicleInfo;
import com.ajax.parkinglot.models.sections.ParkingFloor;
import com.ajax.parkinglot.repositories.ParkingFloorRepository;
import com.ajax.parkinglot.repositories.ParkingLotRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ParkingFloorRepository floorRepository = ParkingFloorRepository.getInstance();
        ParkingFloor floor = floorRepository.get("building1floor2");
        List<ParkingGate> gates = floor.getParkingGates();
        ParkingGate entryGate = null;
        for(ParkingGate gate : gates) {
            if(GateTypeEnum.ENTRY.equals(gate.getGateType())) {
                entryGate = gate;
                break;
            }
        }
        VehicleInfo info = new VehicleInfo("RJ 01 1234", VehicleTypeEnum.BIKE);
        ParkingTicket ticket = entryGate.generateTicket(info, TicketGeneratorStrategyEnum.SAME_OR_BIGGER_LOT_FLOOR_STRATEGY);
        while(ticket!=null) {
            System.out.println(ticket);
            ticket = entryGate.generateTicket(info, TicketGeneratorStrategyEnum.SAME_OR_BIGGER_LOT_FLOOR_STRATEGY);
        }
    }
}
