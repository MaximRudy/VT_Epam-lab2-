package com.epam.rudy.repository.xmldao.adapter;

import com.epam.rudy.entity.Bicycle;
import com.epam.rudy.repository.xmldao.entity.XMLBicycle;

public class XMLBicycleAdapter implements XMLAdapter<XMLBicycle, Bicycle> {

	@Override
	public XMLBicycle toXML(Bicycle object) {
		return new XMLBicycle(
				object.getId(),
				object.getVehicleType(),
				object.getModel(),
				object.getYearOfManufacture(),
				object.isIndependentVehicle()
		);
	}

	@Override
	public Bicycle toObject(XMLBicycle xml) {
		return new Bicycle(
				xml.getId(),
				xml.getVehicleType(),
				xml.getModel(),
				xml.getYearOfManufacture(),
				xml.getIsIndependentVehicle()
		);
	}
}
