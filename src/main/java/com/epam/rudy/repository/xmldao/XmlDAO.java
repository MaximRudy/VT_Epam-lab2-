package com.epam.rudy.repository.xmldao;

import com.epam.rudy.repository.SimpleDAO;
import com.epam.rudy.repository.xmldao.adapter.XMLAdapter;
import com.epam.rudy.repository.xmldao.entity.XMLObjectsList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public abstract class XmlDAO<T, X> implements SimpleDAO<T> {

	private static Logger logger = LogManager.getLogger();

	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public XmlDAO() {
		try {
			JAXBContext context = JAXBContext.newInstance(XMLObjectsList.class);
			marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			unmarshaller = context.createUnmarshaller();

			if (getXsdPath() != null) {
				SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				marshaller.setSchema(sf.newSchema(new File(getXsdPath())));
				unmarshaller.setSchema(sf.newSchema(new File(getXsdPath())));
			}
		} catch (JAXBException | SAXException exc) {
			logger.fatal(exc.toString());
		}
	}

	abstract String getXmlPath();

	abstract String getXsdPath();

	abstract XMLAdapter<X, T> getAdapter();

	@Override
	public void save(List<T> objects) {
		try {
			XMLObjectsList<X> list = new XMLObjectsList<>();
			list.setList(objects.stream()
					.map(getAdapter()::toXML)
					.collect(Collectors.toList())
			);
			marshaller.marshal(list, new File(getXmlPath()));
		} catch (JAXBException exc) {
			logger.error(exc.toString());
		}
	}

	@Override
	public List<T> read() {
		try {
			XMLObjectsList<X> list = (XMLObjectsList<X>) unmarshaller.unmarshal(new File(getXmlPath()));
			return list.getList().stream()
					.map((o) -> getAdapter().toObject(o))
					.collect(Collectors.toList());
		} catch (JAXBException exc) {
			logger.error(exc.toString());
			return null;
		}
	}
}
