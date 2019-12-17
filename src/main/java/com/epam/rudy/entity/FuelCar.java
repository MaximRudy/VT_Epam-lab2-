package com.epam.rudy.entity;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonIgnoreProperties(ignoreUnknown=true)
public class FuelCar extends CombustionFuelVehicle {

    @JsonCreator
    public FuelCar(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType vehicleType,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("enginePower") int enginePower,
        @JsonProperty("carBodyType") CarBodyType carBodyType,
        @JsonProperty("engineCapacity") int engineCapacity) {
        super(id, vehicleType, model, yearOfManufacture, enginePower, carBodyType, engineCapacity);
    }

    public FuelCar(VehicleType vehicleType,
        String model,
        int yearOfManufacture,
        int enginePower,
        CarBodyType carBodyType,
        int engineCapacity) {
        super(vehicleType, model, yearOfManufacture, enginePower, carBodyType, engineCapacity);
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setEngineEcoTestPassed((rand.nextInt() % 2 == 0) ? true : false);
    }

    @Override
    public String toString() {
        return "FuelCar{" + super.toString() + "}";
    }
}
