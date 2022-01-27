package com.ajax.parkinglot.repositories;


import com.ajax.parkinglot.enums.ParkingSizeEnum;
import com.ajax.parkinglot.models.sections.ParkingFloor;
import com.ajax.parkinglot.models.sections.ParkingLot;

import java.util.*;

public class ParkingLotRepository {
    private static ParkingLotRepository INSTANCE;
    Map<String, List<ParkingLot>> floorVsParking;

    private ParkingLotRepository() {
        floorVsParking = new HashMap<>();

        Collection<ParkingFloor> parkingFloors = ParkingFloorRepository.getInstance().getAllFloors();

        for(ParkingFloor floor : parkingFloors) {
            floorVsParking.put(floor.getSectionId(), new ArrayList<>());
            ParkingLot lot1 = new ParkingLot("parkingLot1", ParkingSizeEnum.SMALL);
            ParkingLot lot2 = new ParkingLot("parkingLot2", ParkingSizeEnum.MEDIUM);
            ParkingLot lot3 = new ParkingLot("parkingLot3", ParkingSizeEnum.LARGE);

            lot1.setParentSection(floor);
            lot2.setParentSection(floor);
            lot3.setParentSection(floor);

            floor.addParkingLot(lot1, lot2, lot3);

            floorVsParking.get(floor.getSectionId()).add(lot1);
            floorVsParking.get(floor.getSectionId()).add(lot2);
            floorVsParking.get(floor.getSectionId()).add(lot3);
        }
    }

    public ParkingLot getParkingLot(String floorId, ParkingSizeEnum sizeEnum) {
        List<ParkingLot> lots = floorVsParking.get(floorId);
        for(ParkingLot lot : lots) {
            if(!lot.isFilled() && lot.getParkingSizeEnum().equals(sizeEnum)) {
                return lot;
            }
        }
        return null;
    }


    public static ParkingLotRepository getInstance() {
        if(INSTANCE==null) {
            synchronized (ParkingLotRepository.class) {
                if(INSTANCE==null) {
                    INSTANCE = new ParkingLotRepository();
                }
            }
        }
        return INSTANCE;
    }
}
