package com.epam.rudy.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;
import java.util.Random;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonIgnoreProperties(ignoreUnknown=true)
public class HouseOnWheels extends CombustionFuelVehicle {

    /**  */
    private final boolean isKitchenPresent;

    @JsonCreator
    public HouseOnWheels(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType vehicleType,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("enginePower") int enginePower,
        @JsonProperty("carBodyType") CarBodyType carBodyType,
        @JsonProperty("engineCapacity") int engineCapacity,
        @JsonProperty("isKitchenPresent") boolean isKitchenPresent) {
        super(id, vehicleType, model, yearOfManufacture, enginePower, CarBodyType.WAGON, engineCapacity);
        this.isKitchenPresent = isKitchenPresent;
    }

    public HouseOnWheels(VehicleType vehicleType,
                         String model,
                         int yearOfManufacture,
                         int enginePower,
                         int engineCapacity,
                         boolean isKitchenPresent) {
        super(vehicleType, model, yearOfManufacture, enginePower, CarBodyType.WAGON, engineCapacity);
        this.isKitchenPresent = isKitchenPresent;
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setEngineEcoTestPassed((rand.nextInt() % 2 == 0) ? true : false);
    }

    public boolean isKitchenPresent() {
        return isKitchenPresent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof HouseOnWheels))
            return false;
        if (!super.equals(o))
            return false;
        HouseOnWheels that = (HouseOnWheels) o;
        return isKitchenPresent == that.isKitchenPresent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isKitchenPresent);
    }

    @Override
    public String toString() {
        return "HouseOnWheels{" + super.toString() + ", isKitchenPresent'=" + isKitchenPresent + "'}";
    }
}
