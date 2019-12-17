package com.epam.rudy.repository.xmldao.adapter;

import com.epam.rudy.entity.Bus;
import com.epam.rudy.repository.xmldao.entity.XMLBus;

public class XMLBusAdapter implements XMLAdapter<XMLBus, Bus> {

	@Override
	public XMLBus toXML(Bus object) {
		return new XMLBus(
				object.getId(),
				object.getVehicleType(),
				object.getModel(),
				object.getYearOfManufacture(),
				object.getEnginePower(),
				object.getCarBodyType(),
				object.getEngineCapacity(),
				object.getNumberOfAxles()
		);
	}

	@Override
	public Bus toObject(XMLBus xml) {
		return new Bus(
				xml.getId(),
				xml.getVehicleType(),
				xml.getModel(),
				xml.getYearOfManufacture(),
				xml.getEnginePower(),
				xml.getCarBodyType(),
				xml.getEngineCapacity(),
				xml.getNumberOfAxles()
		);
	}
}
