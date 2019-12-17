package com.epam.rudy.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.WRAPPER_OBJECT,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Bicycle.class, name = "bicycle"),
    @JsonSubTypes.Type(value = Trailer.class, name = "trailer")
})
public abstract class MechanicalVehicle extends Vehicle {

    /**  */
    private final boolean isIndependentVehicle;

    /**  */
    private boolean isLightingSystemGood;

    protected MechanicalVehicle(String id,
                                VehicleType type,
                                String model,
                                int yearOfManufacture,
                                boolean isIndependentVehicle) {
        super(id, type, model, yearOfManufacture);
        this.isIndependentVehicle = isIndependentVehicle;
    }

    protected MechanicalVehicle(VehicleType type,
                               String model,
                               int yearOfManufacture,
                               boolean isIndependentVehicle) {
        super(type, model, yearOfManufacture);
        this.isIndependentVehicle = isIndependentVehicle;
    }

    public boolean isIndependentVehicle() { return isIndependentVehicle; }

    public boolean isLightingSystemGood() {
        return isLightingSystemGood;
    }

    @JsonIgnore
    public void setLightingSystemGood(boolean lightingSystemGood) {
        isLightingSystemGood = lightingSystemGood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MechanicalVehicle))
            return false;
        if (!super.equals(o))
            return false;
        MechanicalVehicle that = (MechanicalVehicle) o;
        return isIndependentVehicle == that.isIndependentVehicle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isIndependentVehicle);
    }

    @Override
    public String toString() {
        return super.toString() + ", isIndependentVehicle='" + isIndependentVehicle + '\'';
    }
}
