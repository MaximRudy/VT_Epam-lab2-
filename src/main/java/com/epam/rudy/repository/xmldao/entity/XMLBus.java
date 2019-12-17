package com.epam.rudy.repository.xmldao.entity;

import com.epam.rudy.entity.CarBodyType;
import com.epam.rudy.entity.VehicleType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id", "vehicleType", "model", "yearOfManufacture", "enginePower",
		"carBodyType", "engineCapacity", "numberOfAxles"})
public class XMLBus {

	private String id;
	private VehicleType vehicleType;
	private String model;
	private int yearOfManufacture;
	private int enginePower;
	private CarBodyType carBodyType;
	private int engineCapacity;
	private int numberOfAxles;

	public XMLBus() {

	}

	public XMLBus(
			String id,
			VehicleType vehicleType,
			String model,
			int yearOfManufacture,
			int enginePower,
			CarBodyType carBodyType,
			int engineCapacity,
			int numberOfAxles
	) {
		this.id = id;
		this.vehicleType = vehicleType;
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.enginePower = enginePower;
		this.carBodyType = carBodyType;
		this.engineCapacity = engineCapacity;
		this.numberOfAxles = numberOfAxles;
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

	@XmlElement(name = "enginePower")
	public int getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	@XmlElement(name = "carBodyType")
	public CarBodyType getCarBodyType() {
		return carBodyType;
	}

	public void setCarBodyType(CarBodyType carBodyType) {
		this.carBodyType = carBodyType;
	}

	@XmlElement(name = "engineCapacity")
	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	@XmlElement(name = "numberOfAxles")
	public int getNumberOfAxles() {
		return numberOfAxles;
	}

	public void setNumberOfAxles(int numberOfAxles) {
		this.numberOfAxles = numberOfAxles;
	}
}
