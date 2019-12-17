package com.epam.rudy.repository.xmldao.adapter;

import com.epam.rudy.entity.Minibus;
import com.epam.rudy.repository.xmldao.entity.XMLMinibus;

public class XMLMinibusAdapter implements XMLAdapter<XMLMinibus, Minibus> {

	@Override
	public XMLMinibus toXML(Minibus object) {
		return new XMLMinibus(
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
	public Minibus toObject(XMLMinibus xml) {
		return new Minibus(
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
