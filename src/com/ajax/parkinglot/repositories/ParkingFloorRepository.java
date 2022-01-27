package com.ajax.parkinglot.repositories;

import com.ajax.parkinglot.enums.GateTypeEnum;
import com.ajax.parkinglot.models.ParkingGate;
import com.ajax.parkinglot.models.sections.ParkingBuilding;
import com.ajax.parkinglot.models.sections.ParkingFloor;

import java.util.*;

public class ParkingFloorRepository {
    Map<String, ParkingFloor> parkingFloorMap;
    public static ParkingFloorRepository INSTANCE;
    Map<String, List<String>> buildingVsParkingFloor;
    private ParkingFloorRepository() {
        parkingFloorMap = new HashMap<>();
        buildingVsParkingFloor = new HashMap<>();
        ParkingBuildingRepository parkingBuildingRepository = ParkingBuildingRepository.getInstance();
        Collection<ParkingBuilding> buildings = parkingBuildingRepository.getAllBuildings();
        // adding 3 floors in each building
        for(ParkingBuilding building : buildings) {
            buildingVsParkingFloor.put(building.getSectionId(), new ArrayList<>());
            ParkingFloor pf1 = new ParkingFloor("floor1");
            ParkingFloor pf2 = new ParkingFloor("floor2");
            ParkingFloor pf3 = new ParkingFloor("floor3");
            pf1.setParentSection(building);
            pf2.setParentSection(building);
            pf3.setParentSection(building);
            building.addParkingFloor(pf1, pf2, pf3);

            // Gates:
            ParkingGate pf1g1 = new ParkingGate("floor1gate1entry", GateTypeEnum.ENTRY, pf1);
            ParkingGate pf1g2 = new ParkingGate("floor1gate2exit", GateTypeEnum.EXIT, pf1);
            ParkingGate pf2g1 = new ParkingGate("floor2gate1entry", GateTypeEnum.ENTRY, pf2);
            ParkingGate pf2g2 = new ParkingGate("floor2gate2exit", GateTypeEnum.EXIT, pf2);
            ParkingGate pf3g1 = new ParkingGate("floor3gate1entry", GateTypeEnum.ENTRY, pf3);
            ParkingGate pf3g2 = new ParkingGate("floor3gate2exit", GateTypeEnum.EXIT, pf3);

            pf1.addParkingGate(pf1g1, pf1g2);
            pf2.addParkingGate(pf2g1, pf2g2);
            pf3.addParkingGate(pf3g1, pf3g2);

            // add in map:
            parkingFloorMap.put(pf1.getSectionId(), pf1);
            parkingFloorMap.put(pf2.getSectionId(), pf2);
            parkingFloorMap.put(pf3.getSectionId(), pf3);

            buildingVsParkingFloor.get(building.getSectionId()).add(pf1.getSectionId());
            buildingVsParkingFloor.get(building.getSectionId()).add(pf2.getSectionId());
            buildingVsParkingFloor.get(building.getSectionId()).add(pf3.getSectionId());
        }
    }

    public static ParkingFloorRepository getInstance() {
        if(INSTANCE==null) {
            synchronized (ParkingFloorRepository.class) {
                if(INSTANCE==null) {
                    INSTANCE = new ParkingFloorRepository();
                }
            }
        }
        return INSTANCE;
    }

    public ParkingFloor get(String id) {
        return parkingFloorMap.get(id);
    }

    public Collection<ParkingFloor> getAllFloors() {
        return parkingFloorMap.values();
    }
}
