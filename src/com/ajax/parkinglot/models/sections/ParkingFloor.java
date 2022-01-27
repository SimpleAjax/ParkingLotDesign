package com.ajax.parkinglot.models.sections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingFloor extends GatedSection {

    List<ParkingLot> parkingLots;
    public ParkingFloor(String sectionId) {
        super(sectionId);
        parkingLots = new ArrayList<>();
    }

    public void addParkingLot(ParkingLot... parkingLot) {
        parkingLots.addAll(Arrays.asList(parkingLot));
    }
}
