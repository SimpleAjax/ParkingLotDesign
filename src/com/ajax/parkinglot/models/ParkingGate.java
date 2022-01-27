package com.ajax.parkinglot.models;

import com.ajax.parkinglot.enums.GateTypeEnum;
import com.ajax.parkinglot.enums.TicketGeneratorStrategyEnum;
import com.ajax.parkinglot.models.sections.Section;

public class ParkingGate {
    private final String gateId;
    private final String ticketIdPrefix;
    private int idIterator;
    private final GateTypeEnum gateType;
    private final Section parentSection;

    public ParkingGate(String gateId, GateTypeEnum gateType, Section parentSection) {
        this.gateId = gateId;
        this.gateType = gateType;
        this.parentSection = parentSection;
        idIterator = 1;
        ticketIdPrefix = parentSection.getSectionId();
    }

    public ParkingTicket generateTicket(VehicleInfo vehicleInfo, TicketGeneratorStrategyEnum ticketGeneratorStrategyEnum) {
        return ticketGeneratorStrategyEnum.getTicketGenerator().generateTicket(vehicleInfo, this);
    }

    public String generateTicketId() {
        String ticketId = ticketIdPrefix + idIterator;
        idIterator++;
        return ticketId;
    }

    public String getGateId() {
        return gateId;
    }

    public GateTypeEnum getGateType() {
        return gateType;
    }

    public Section getParentSection() {
        return parentSection;
    }
}
