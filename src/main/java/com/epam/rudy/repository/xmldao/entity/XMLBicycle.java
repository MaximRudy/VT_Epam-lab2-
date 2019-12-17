package com.epam.rudy.repository.xmldao.entity;

import com.epam.rudy.entity.VehicleType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id", "vehicleType", "model", "yearOfManufacture", "isIndependentVehicle"})
public class XMLBicycle {

	private String id;
	private VehicleType vehicleType;
	private String model;
	private int yearOfManufacture;
	private boolean isIndependentVehicle;

	public XMLBicycle() {

	}

	public XMLBicycle(String id, VehicleType vehicleType, String model, int yearOfManufacture, boolean isIndependentVehicle) {
		this.id = id;
		this.vehicleType = vehicleType;
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.isIndependentVehicle = isIndependentVehicle;
	}

	@XmlElement(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "vehicleType")
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@XmlElement(name = "model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@XmlElement(name = "yearOfManufacture")
	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	@XmlElement(name = "isIndependentVehicle")
	public boolean getIsIndependentVehicle() {
		return isIndependentVehicle;
	}

	public void setIsIndependentVehicle(boolean isIndependentVehicle) {
		this.isIndependentVehicle = isIndependentVehicle;
	}
}
