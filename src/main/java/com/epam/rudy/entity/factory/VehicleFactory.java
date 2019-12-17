package com.epam.rudy.entity.factory;

import com.epam.rudy.entity.*;

/**
 *
 */
public final class VehicleFactory {

    private VehicleFactory() {}

    public static Vehicle createVehicle(VehicleType vehicleType,
                                        String vehicleModel,
                                        int yearOfManufacture,
                                        boolean isIndependentVehicle,
                                        int enginePower,
                                        CarBodyType carBodyType,
                                        int engineCapacity,
                                        int timeToCharge,
                                        int numberOfAxles,
                                        boolean isKitchenPresent) {
        Vehicle vehicle = null;
        switch(vehicleType) {
            case FUEL_CAR:
                vehicle = new FuelCar(vehicleType, vehicleModel, yearOfManufacture, enginePower, carBodyType, engineCapacity);
                break;
            case ELECTRO_CAR:
                vehicle = new ElectroCar(vehicleType, vehicleModel, yearOfManufacture, enginePower, carBodyType, timeToCharge);
                break;
            case MINIBUS:
                vehicle = new Minibus(vehicleType, vehicleModel, yearOfManufacture, enginePower, engineCapacity);
                break;
            case BUS:
                vehicle = new Bus(vehicleType, vehicleModel, yearOfManufacture, enginePower, engineCapacity, numberOfAxles);
                break;
            case HOUSE_ON_WHEELS:
                vehicle = new HouseOnWheels(vehicleType, vehicleModel, yearOfManufacture, enginePower, engineCapacity, isKitchenPresent);
                break;
            case TRAILER:
                vehicle = new Trailer(vehicleType, vehicleModel, yearOfManufacture, isIndependentVehicle);
                break;
            case BICYCLE:
                vehicle = new Bicycle(vehicleType, vehicleModel, yearOfManufacture, isIndependentVehicle);
                break;
            default:
                break;
        }
        return vehicle;
    }
}
