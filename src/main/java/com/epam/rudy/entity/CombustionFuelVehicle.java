package com.epam.rudy.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.WRAPPER_OBJECT,
    property = "name")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FuelCar.class),
    @JsonSubTypes.Type(value = Bus.class),
    @JsonSubTypes.Type(value = Minibus.class),
    @JsonSubTypes.Type(value = HouseOnWheels.class)
})
public abstract class CombustionFuelVehicle extends EngineVehicle {

    /**  */
    private final int engineCapacity;

    /**  */
    private boolean isEngineEcoTestPassed;

    protected CombustionFuelVehicle(String id,
                                VehicleType vehicleType,
                                String model,
                                int yearOfManufacture,
                                int enginePower,
                                CarBodyType carBodyType,
                                int engineCapacity) {
        super(id, vehicleType, model, yearOfManufacture, enginePower, carBodyType);
        this.engineCapacity = engineCapacity;
    }

    protected CombustionFuelVehicle(VehicleType vehicleType,
                                 String model,
                                 int yearOfManufacture,
                                 int enginePower,
                                 CarBodyType carBodyType,
                                 int engineCapacity) {
        super(vehicleType, model, yearOfManufacture, enginePower,carBodyType);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public boolean isEngineEcoTestPassed() {
        return isEngineEcoTestPassed;
    }

    @JsonIgnore
    protected void setEngineEcoTestPassed(boolean engineEcoTestPassed) {
        isEngineEcoTestPassed = engineEcoTestPassed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CombustionFuelVehicle)) return false;
        if (!super.equals(o)) return false;
        CombustionFuelVehicle that = (CombustionFuelVehicle) o;
        return engineCapacity == that.engineCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineCapacity);
    }

    @Override
    public String toString() {
        return super.toString() + ", engineCapacity=" + engineCapacity + '\'';
    }
}
