package com.epam.rudy.entity;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.WRAPPER_OBJECT,
    property = "name")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Trailer extends MechanicalVehicle {

    @JsonCreator
    public Trailer(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType vehicleType,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("isIndependentVehicle") boolean isIndependentVehicle) {
        super(id, vehicleType, model, yearOfManufacture, isIndependentVehicle);
    }

    public Trailer(VehicleType vehicleType,
                   String model,
                   int yearOfManufacture,
                   boolean isIndependentVehicle) {
        super(vehicleType, model, yearOfManufacture, isIndependentVehicle);
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setLightingSystemGood((rand.nextInt() % 2 == 0) ? true : false);
    }
}
