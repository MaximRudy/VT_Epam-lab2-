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
public class Minibus extends CombustionFuelVehicle {

    @JsonCreator
    public Minibus(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType vehicleType,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("enginePower") int enginePower,
        @JsonProperty("carBodyType") CarBodyType carBodyType,
        @JsonProperty("engineCapacity") int engineCapacity) {
        super(id, vehicleType, model, yearOfManufacture, enginePower, CarBodyType.WAGON, engineCapacity);
    }

    public Minibus(VehicleType vehicleType,
                   String model,
                   int yearOfManufacture,
                   int enginePower,
                   int engineCapacity) {
        super(vehicleType, model, yearOfManufacture, enginePower, CarBodyType.WAGON, engineCapacity);
    }

    @Override
    public String toString() {
        return "Minibus{" + super.toString() + "}";
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setEngineEcoTestPassed((rand.nextInt() % 2 == 0) ? true : false);
    }
}
