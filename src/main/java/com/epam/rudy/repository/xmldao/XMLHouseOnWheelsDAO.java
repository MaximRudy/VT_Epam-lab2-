package com.epam.rudy.repository.xmldao;

import com.epam.rudy.entity.HouseOnWheels;
import com.epam.rudy.repository.xmldao.adapter.XMLAdapter;
import com.epam.rudy.repository.xmldao.adapter.XMLHouseOnWheelsAdapter;
import com.epam.rudy.repository.xmldao.entity.XMLHouseOnWheels;

public class XMLHouseOnWheelsDAO extends XmlDAO<HouseOnWheels, XMLHouseOnWheels> {

	@Override
	String getXmlPath() {
		return "src/main/resources/xml/houseonwheels.xml";
	}

	@Override
	String getXsdPath() {
		return "src/main/resources/xsd/houseonwheels.xsd";
	}

	@Override
	XMLAdapter<XMLHouseOnWheels, HouseOnWheels> getAdapter() {
		return new XMLHouseOnWheelsAdapter();
	}
}
