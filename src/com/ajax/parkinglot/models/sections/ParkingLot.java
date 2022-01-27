package com.ajax.parkinglot.models.sections;

import com.ajax.parkinglot.enums.ParkingSizeEnum;

public class ParkingLot extends Section {

    final private ParkingSizeEnum parkingSizeEnum;
    private boolean isFilled;

    public ParkingLot(String sectionId, ParkingSizeEnum parkingSizeEnum) {
        super(sectionId);
        this.parkingSizeEnum = parkingSizeEnum;
        isFilled = false;
    }

    public ParkingSizeEnum getParkingSizeEnum() {
        return parkingSizeEnum;
    }

    public void fillParking() {
        isFilled = true;
    }

    public void emptyParking() {
        isFilled = false;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public String toString() {
        return "[ "+ sectionId + "\n\t" + parentSection.getSectionId() + "\n\t" + parkingSizeEnum +" ]";
    }
}
