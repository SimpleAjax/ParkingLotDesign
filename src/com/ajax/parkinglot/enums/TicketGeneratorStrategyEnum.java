package com.ajax.parkinglot.enums;

import com.ajax.parkinglot.strategy.SameOrBiggerLotBuildingStrategy;
import com.ajax.parkinglot.strategy.SameOrBiggerLotFloorStrategy;
import com.ajax.parkinglot.strategy.TicketGenerator;

public enum TicketGeneratorStrategyEnum {
    SAME_OR_BIGGER_LOT_BUILDING_STRATEGY(new SameOrBiggerLotBuildingStrategy()),
    SAME_OR_BIGGER_LOT_FLOOR_STRATEGY(new SameOrBiggerLotFloorStrategy());

    private final TicketGenerator ticketGenerator;

    TicketGeneratorStrategyEnum(TicketGenerator ticketGenerator) {
        this.ticketGenerator = ticketGenerator;
    }

    public TicketGenerator getTicketGenerator() {
        return ticketGenerator;
    }
}
