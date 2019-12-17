package com.epam.rudy.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.WRAPPER_OBJECT,
    property = "name")
@JsonSubTypes({
    @JsonSubTypes.Type(value = CombustionFuelVehicle.class),
    @JsonSubTypes.Type(value = EngineVehicle.class)
})
public abstract class EngineVehicle extends Vehicle {

    /**  */
    private final int enginePower;

    /**  */
    private final CarBodyType carBodyType;

    protected EngineVehicle(String id,
                        VehicleType vehicleType,
                        String model,
                        int yearOfManufacture,
                        int enginePower,
                        CarBodyType carBodyType) {
        super(id, vehicleType, model, yearOfManufacture);
        this.enginePower = enginePower;
        this.carBodyType = carBodyType;
    }

    protected EngineVehicle(VehicleType vehicleType,
                         String model,
                         int yearOfManufacture,
                         int enginePower,
                         CarBodyType carBodyType) {
        super(vehicleType, model, yearOfManufacture);
        this.enginePower = enginePower;
        this.carBodyType = carBodyType;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public CarBodyType getCarBodyType() {
        return carBodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EngineVehicle))
            return false;
        if (!super.equals(o))
            return false;
        EngineVehicle that = (EngineVehicle) o;
        return enginePower == that.enginePower && carBodyType == that.carBodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enginePower, carBodyType);
    }

    @Override
    public String toString() {
        return super.toString() + ", enginePower='" + enginePower + ", carBodyType='" + carBodyType + "\'";
    }
}
