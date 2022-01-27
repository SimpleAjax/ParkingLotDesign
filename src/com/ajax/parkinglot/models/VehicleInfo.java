package com.ajax.parkinglot.models;

import com.ajax.parkinglot.enums.VehicleTypeEnum;

public class VehicleInfo {
    private final String vehicleNumberPlate;
    private final VehicleTypeEnum vehicleTypeEnum;

    public VehicleInfo(String vehicleNumberPlate, VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleNumberPlate = vehicleNumberPlate;
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    public String getVehicleNumberPlate() {
        return vehicleNumberPlate;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }
}
