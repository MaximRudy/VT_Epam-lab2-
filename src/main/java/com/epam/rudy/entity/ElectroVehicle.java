package com.epam.rudy.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.WRAPPER_OBJECT,
    property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = ElectroCar.class, name = "electroCar")
})
public abstract class ElectroVehicle extends EngineVehicle {

    /**  */
    private final int timeToCharge;

    /**  */
    private boolean isEngineCircuitPassRateGood;

    protected ElectroVehicle(String id,
                          VehicleType vehicleType,
                          String model,
                          int yearOfManufacture,
                          int enginePower,
                          CarBodyType carBodyType,
                          int timeToCharge) {
        super(id, vehicleType, model, yearOfManufacture, enginePower, carBodyType);
        this.timeToCharge = timeToCharge;
    }

    protected ElectroVehicle(VehicleType vehicleType,
                          String model,
                          int yearOfManufacture,
                          int enginePower,
                          CarBodyType carBodyType,
                          int timeToCharge) {
        super(vehicleType, model, yearOfManufacture, enginePower, carBodyType);
        this.timeToCharge = timeToCharge;
    }

    public int getTimeToCharge() {
        return timeToCharge;
    }

    public boolean isEngineCircuitPassRateGood() {
        return isEngineCircuitPassRateGood;
    }

    @JsonIgnore
    protected void setEngineCircuitPassRateGood(boolean engineCircuitPassRateGood) {
        isEngineCircuitPassRateGood = engineCircuitPassRateGood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ElectroVehicle))
            return false;
        if (!super.equals(o))
            return false;
        ElectroVehicle that = (ElectroVehicle) o;
        return timeToCharge == that.timeToCharge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timeToCharge);
    }

    @Override
    public String toString() {
        return super.toString() + ", timeToCharge='" + timeToCharge + '\'';
    }
}
