package com.ajax.parkinglot.enums;

public enum ParkingSizeEnum {
    SMALL, MEDIUM, LARGE;
    private static final ParkingSizeEnum[] sizes = values();
    public ParkingSizeEnum getNextBiggerSizeEnum() {
        int ordinal = ordinal()+1;
        if(ordinal == sizes.length) return null;
        return sizes[ordinal];
    }
}
