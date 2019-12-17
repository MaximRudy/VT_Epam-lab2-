package com.epam.rudy.repository.xmldao;

import com.epam.rudy.entity.Bicycle;
import com.epam.rudy.repository.xmldao.adapter.XMLAdapter;
import com.epam.rudy.repository.xmldao.adapter.XMLBicycleAdapter;
import com.epam.rudy.repository.xmldao.entity.XMLBicycle;

public class XMLBicycleDAO extends XmlDAO<Bicycle, XMLBicycle> {

	@Override
	String getXmlPath() {
		return "src/main/resources/xml/bicycle.xml";
	}

	@Override
	String getXsdPath() {
		return "src/main/resources/xsd/bicycle.xsd";
	}

	@Override
	XMLAdapter<XMLBicycle, Bicycle> getAdapter() {
		return new XMLBicycleAdapter();
	}
}
