package com.ajax.parkinglot.repositories;

import com.ajax.parkinglot.models.sections.ParkingBuilding;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParkingBuildingRepository {
    private Map<String, ParkingBuilding> buildingIdVsParkingBuilding;
    private static ParkingBuildingRepository INSTANCE;
    private ParkingBuildingRepository() {
        buildingIdVsParkingBuilding = new HashMap<>();
        ParkingBuilding b1 = new ParkingBuilding("building1");
        ParkingBuilding b2 = new ParkingBuilding("building2");

        buildingIdVsParkingBuilding.put(b1.getSectionId(), b1);
        buildingIdVsParkingBuilding.put(b2.getSectionId(), b2);
    }

    public static ParkingBuildingRepository getInstance() {
        if(INSTANCE==null) {
            synchronized (ParkingBuildingRepository.class) {
                if(INSTANCE==null) {
                    INSTANCE = new ParkingBuildingRepository();
                }
            }
        }
        return INSTANCE;
    }

    public Collection<ParkingBuilding> getAllBuildings() {
        return buildingIdVsParkingBuilding.values();
    }
}
