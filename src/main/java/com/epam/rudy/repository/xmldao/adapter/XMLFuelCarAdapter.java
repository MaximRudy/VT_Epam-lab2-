package com.epam.rudy.repository.xmldao.adapter;

import com.epam.rudy.entity.FuelCar;
import com.epam.rudy.repository.xmldao.entity.XMLFuelCar;

public class XMLFuelCarAdapter implements XMLAdapter<XMLFuelCar, FuelCar> {

	@Override
	public XMLFuelCar toXML(FuelCar object) {
		return new XMLFuelCar(
				object.getId(),
				object.getVehicleType(),
				object.getModel(),
				object.getYearOfManufacture(),
				object.getEnginePower(),
				object.getCarBodyType(),
				object.getEngineCapacity()
		);
	}

	@Override
	public FuelCar toObject(XMLFuelCar xml) {
		return new FuelCar(
				xml.getId(),
				xml.getVehicleType(),
				xml.getModel(),
				xml.getYearOfManufacture(),
				xml.getEnginePower(),
				xml.getCarBodyType(),
				xml.getEngineCapacity()
		);
	}
}
