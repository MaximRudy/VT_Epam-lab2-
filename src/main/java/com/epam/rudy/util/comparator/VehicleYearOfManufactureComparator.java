package com.epam.rudy.util.comparator;

import com.epam.rudy.entity.Vehicle;

import java.util.Comparator;

public class VehicleYearOfManufactureComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        if(o1.getYearOfManufacture() > o2.getYearOfManufacture()) {
            return 1;
        } else if(o1.getYearOfManufacture() < o2.getYearOfManufacture()) {
            return -1;
        } else {
            return 0;
        }
    }
}
