package com.epam.rudy.repository.xmldao;

import com.epam.rudy.entity.FuelCar;
import com.epam.rudy.repository.xmldao.adapter.XMLAdapter;
import com.epam.rudy.repository.xmldao.adapter.XMLFuelCarAdapter;
import com.epam.rudy.repository.xmldao.entity.XMLFuelCar;

public class XMLFuelCarDAO extends XmlDAO<FuelCar, XMLFuelCar> {

	@Override
	String getXmlPath() {
		return "src/main/resources/xml/fuelcar.xml";
	}

	@Override
	String getXsdPath() {
		return "src/main/resources/xsd/fuelcar.xsd";
	}

	@Override
	XMLAdapter<XMLFuelCar, FuelCar> getAdapter() {
		return new XMLFuelCarAdapter();
	}
}
