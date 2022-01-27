package com.ajax.parkinglot.models.sections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBuilding extends GatedSection {

    List<ParkingFloor> parkingFloors;
    public ParkingBuilding(String sectionId) {
        super(sectionId);
        parkingFloors = new ArrayList<>();
    }

    public void addParkingFloor(ParkingFloor... parkingFloor) {
        parkingFloors.addAll(Arrays.asList(parkingFloor));
    }

}
