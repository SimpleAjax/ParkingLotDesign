package com.ajax.parkinglot.enums;

public enum VehicleTypeEnum {
    BIKE(ParkingSizeEnum.SMALL), HATCHBACK(ParkingSizeEnum.MEDIUM), SEDAN(ParkingSizeEnum.LARGE), SUV(ParkingSizeEnum.LARGE);

    private final ParkingSizeEnum parkingSizeEnum;

    VehicleTypeEnum(ParkingSizeEnum parkingSizeEnum) {
        this.parkingSizeEnum = parkingSizeEnum;
    }

    public ParkingSizeEnum getParkingSizeEnum() {
        return parkingSizeEnum;
    }
}
