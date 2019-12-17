package com.epam.rudy.repository.xmldao.adapter;

import com.epam.rudy.entity.ElectroCar;
import com.epam.rudy.repository.xmldao.entity.XMLElectroCar;

public class XMLElectroCarAdapter implements XMLAdapter<XMLElectroCar, ElectroCar> {

	@Override
	public XMLElectroCar toXML(ElectroCar object) {
		return new XMLElectroCar(
				object.getId(),
				object.getVehicleType(),
				object.getModel(),
				object.getYearOfManufacture(),
				object.getEnginePower(),
				object.getCarBodyType(),
				object.getTimeToCharge()
		);
	}

	@Override
	public ElectroCar toObject(XMLElectroCar xml) {
		return new ElectroCar(
				xml.getId(),
				xml.getVehicleType(),
				xml.getModel(),
				xml.getYearOfManufacture(),
				xml.getEnginePower(),
				xml.getCarBodyType(),
				xml.getTimeToCharge()
		);
	}
}
