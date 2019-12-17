package com.epam.rudy.repository.xmldao.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "data")
@XmlType(propOrder = {"list"})
@XmlSeeAlso({XMLBicycle.class, XMLBus.class, XMLElectroCar.class,
		XMLFuelCar.class, XMLHouseOnWheels.class, XMLMinibus.class, XMLTrailer.class})
public class XMLObjectsList<T> {

	private List<T> list;

	@XmlElement(name = "item")
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
