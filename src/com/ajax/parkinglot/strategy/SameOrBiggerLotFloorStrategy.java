package com.ajax.parkinglot.strategy;

import com.ajax.parkinglot.enums.ParkingSizeEnum;
import com.ajax.parkinglot.models.ParkingGate;
import com.ajax.parkinglot.models.ParkingTicket;
import com.ajax.parkinglot.models.VehicleInfo;
import com.ajax.parkinglot.models.sections.ParkingLot;
import com.ajax.parkinglot.repositories.ParkingLotRepository;

public class SameOrBiggerLotFloorStrategy implements TicketGenerator {

    ParkingLotRepository parkingLotRepository;
    @Override
    public ParkingTicket generateTicket(VehicleInfo vehicleInfo, ParkingGate gate) {
        ParkingSizeEnum sizeEnum = vehicleInfo.getVehicleTypeEnum().getParkingSizeEnum();
        parkingLotRepository = ParkingLotRepository.getInstance();
        String floorId = gate.getParentSection().getSectionId();
        while(sizeEnum!=null) {
            ParkingLot lot = parkingLotRepository.getParkingLot(floorId, sizeEnum);
            if(lot!=null) {
                lot.fillParking();
                return new ParkingTicket("ticketNo", "barCode",
                        gate.generateTicketId(), lot);
            }
            sizeEnum = sizeEnum.getNextBiggerSizeEnum();
        }
        return null;
    }
}
