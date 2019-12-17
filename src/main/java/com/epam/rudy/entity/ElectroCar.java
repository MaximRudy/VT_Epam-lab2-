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
public class ElectroCar extends ElectroVehicle {

    @JsonCreator
    public ElectroCar(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType vehicleType,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("enginePower") int enginePower,
        @JsonProperty("carBodyType") CarBodyType carBodyType,
        @JsonProperty("timeToCharge") int timeToCharge) {
        super(id, vehicleType, model, yearOfManufacture, enginePower, carBodyType, timeToCharge);
    }

    public ElectroCar(VehicleType vehicleType,
                      String model,
                      int yearOfManufacture,
                      int enginePower,
                      CarBodyType carBodyType,
                      int timeToCharge) {
        super(vehicleType, model, yearOfManufacture, enginePower, carBodyType, timeToCharge);
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setEngineCircuitPassRateGood((rand.nextInt() % 2 == 0) ? true : false);
    }

    @Override
    public String toString() {
        return "ElectroCar{" + super.toString() + "}";
    }
}