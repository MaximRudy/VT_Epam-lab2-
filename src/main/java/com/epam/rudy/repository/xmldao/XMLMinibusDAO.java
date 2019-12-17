package com.epam.rudy.repository.xmldao;

import com.epam.rudy.entity.Minibus;
import com.epam.rudy.repository.xmldao.adapter.XMLAdapter;
import com.epam.rudy.repository.xmldao.adapter.XMLMinibusAdapter;
import com.epam.rudy.repository.xmldao.entity.XMLMinibus;

public class XMLMinibusDAO extends XmlDAO<Minibus, XMLMinibus> {

	@Override
	String getXmlPath() {
		return "src/main/resources/xml/minibus.xml";
	}

	@Override
	String getXsdPath() {
		return "src/main/resources/xsd/minibus.xsd";
	}

	@Override
	XMLAdapter<XMLMinibus, Minibus> getAdapter() {
		return new XMLMinibusAdapter();
	}
}
