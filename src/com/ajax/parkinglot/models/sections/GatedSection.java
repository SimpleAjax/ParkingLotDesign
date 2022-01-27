package com.ajax.parkinglot.models.sections;

import com.ajax.parkinglot.models.ParkingGate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class GatedSection extends Section {

    private final List<ParkingGate> parkingGates;

    public GatedSection(String sectionId) {
        super(sectionId);
        parkingGates = new ArrayList<>();
    }

    public List<ParkingGate> getParkingGates() {
        return parkingGates;
    }

    public void addParkingGate(ParkingGate... parkingGate) {
        parkingGates.addAll(Arrays.asList(parkingGate));
    }

}
