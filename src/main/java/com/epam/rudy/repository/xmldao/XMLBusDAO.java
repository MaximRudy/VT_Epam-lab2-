package com.epam.rudy.repository.xmldao;

import com.epam.rudy.entity.Bus;
import com.epam.rudy.repository.xmldao.adapter.XMLAdapter;
import com.epam.rudy.repository.xmldao.adapter.XMLBusAdapter;
import com.epam.rudy.repository.xmldao.entity.XMLBus;

public class XMLBusDAO extends XmlDAO<Bus, XMLBus> {

	@Override
	String getXmlPath() {
		return "src/main/resources/xml/bus.xml";
	}

	@Override
	String getXsdPath() {
		return "src/main/resources/xsd/bus.xsd";
	}

	@Override
	XMLAdapter<XMLBus, Bus> getAdapter() {
		return new XMLBusAdapter();
	}
}
