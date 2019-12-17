package com.epam.rudy.repository.xmldao.adapter;

import com.epam.rudy.entity.HouseOnWheels;
import com.epam.rudy.repository.xmldao.entity.XMLHouseOnWheels;

public class XMLHouseOnWheelsAdapter implements XMLAdapter<XMLHouseOnWheels, HouseOnWheels> {

	@Override
	public XMLHouseOnWheels toXML(HouseOnWheels object) {
		return new XMLHouseOnWheels(
				object.getId(),
				object.getVehicleType(),
				object.getModel(),
				object.getYearOfManufacture(),
				object.getEnginePower(),
				object.getCarBodyType(),
				object.getEngineCapacity(),
				object.isKitchenPresent()
		);
	}

	@Override
	public HouseOnWheels toObject(XMLHouseOnWheels xml) {
		return new HouseOnWheels(
				xml.getId(),
				xml.getVehicleType(),
				xml.getModel(),
				xml.getYearOfManufacture(),
				xml.getEnginePower(),
				xml.getCarBodyType(),
				xml.getEngineCapacity(),
				xml.getIsKitchenPresent()
		);
	}
}
