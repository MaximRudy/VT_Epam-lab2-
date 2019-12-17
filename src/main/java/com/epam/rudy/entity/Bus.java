package com.epam.rudy.entity;

import java.util.Objects;
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
public class Bus extends CombustionFuelVehicle {

    /**  */
    private final int numberOfAxles;

    @JsonCreator
    public Bus(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType vehicleType,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("enginePower") int enginePower,
        @JsonProperty("carBodyType") CarBodyType carBodyType,
        @JsonProperty("engineCapacity") int engineCapacity,
        @JsonProperty("numberOfAxles") int numberOfAxles) {
        super(id, vehicleType, model, yearOfManufacture, enginePower, CarBodyType.WAGON, engineCapacity);
        this.numberOfAxles = numberOfAxles;
    }

    public Bus(VehicleType vehicleType,
               String model,
               int yearOfManufacture,
               int enginePower,
               int engineCapacity,
               int numberOfAxles) {
        super(vehicleType, model, yearOfManufacture, enginePower, CarBodyType.WAGON, engineCapacity);
        this.numberOfAxles = numberOfAxles;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
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
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Bus))
            return false;
        if (!super.equals(o))
            return false;
        Bus bus = (Bus) o;
        return numberOfAxles == bus.numberOfAxles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfAxles);
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() + ", numberOfAxles='" + numberOfAxles + "'}";
    }
}
