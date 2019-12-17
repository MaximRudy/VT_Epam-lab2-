package com.epam.rudy.repository.xmldao.adapter;

import com.epam.rudy.entity.Trailer;
import com.epam.rudy.repository.xmldao.entity.XMLTrailer;

public class XMLTrailerAdapter implements XMLAdapter<XMLTrailer, Trailer> {

	@Override
	public XMLTrailer toXML(Trailer object) {
		return new XMLTrailer(
				object.getId(),
				object.getVehicleType(),
				object.getModel(),
				object.getYearOfManufacture(),
				object.isIndependentVehicle()
		);
	}

	@Override
	public Trailer toObject(XMLTrailer xml) {
		return new Trailer(
				xml.getId(),
				xml.getVehicleType(),
				xml.getModel(),
				xml.getYearOfManufacture(),
				xml.getIsIndependentVehicle()
		);
	}
}
