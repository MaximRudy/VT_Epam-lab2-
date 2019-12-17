package com.epam.rudy.repository.xmldao;

import com.epam.rudy.entity.ElectroCar;
import com.epam.rudy.repository.xmldao.adapter.XMLAdapter;
import com.epam.rudy.repository.xmldao.adapter.XMLElectroCarAdapter;
import com.epam.rudy.repository.xmldao.entity.XMLElectroCar;

public class XMLElectroCarDAO extends XmlDAO<ElectroCar, XMLElectroCar> {

	@Override
	String getXmlPath() {
		return "src/main/resources/xml/electrocar.xml";
	}

	@Override
	String getXsdPath() {
		return "src/main/resources/xsd/electrocar.xsd";
	}

	@Override
	XMLAdapter<XMLElectroCar, ElectroCar> getAdapter() {
		return new XMLElectroCarAdapter();
	}
}
