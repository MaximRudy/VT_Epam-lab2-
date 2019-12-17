package com.epam.rudy.repository.xmldao;

import com.epam.rudy.entity.Trailer;
import com.epam.rudy.repository.xmldao.adapter.XMLAdapter;
import com.epam.rudy.repository.xmldao.adapter.XMLTrailerAdapter;
import com.epam.rudy.repository.xmldao.entity.XMLTrailer;

public class XMLTrailerDAO extends XmlDAO<Trailer, XMLTrailer> {

	@Override
	String getXmlPath() {
		return "src/main/resources/xml/trailer.xml";
	}

	@Override
	String getXsdPath() {
		return "src/main/resources/xsd/trailer.xsd";
	}

	@Override
	XMLAdapter<XMLTrailer, Trailer> getAdapter() {
		return new XMLTrailerAdapter();
	}
}
