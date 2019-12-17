package com.epam.rudy.repository;

import com.epam.rudy.repository.mysqldao.*;
import com.epam.rudy.repository.xmldao.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Transfer {

	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		int option = -1;
		Scanner scanner = new Scanner(System.in);
		while (option != 0) {
			System.out.println("\nPlease choose the action:");
			System.out.println("1 - Save data from RAM to XML");
			System.out.println("2 - Move data from XML to DB");
			System.out.println("0 - Exit");
			option = scanner.nextInt();

			switch (option) {
				case 1:
					saveDataToXml();
					break;
				case 2:
					moveFromXmlToDB();
					break;
			}
		}
	}

	private static void moveFromXmlToDB() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("src/main/resources/repository.properties")));
		} catch (IOException exc) {
			logger.fatal(exc.toString());
		}
		String url = properties.getProperty("host");
		String login = properties.getProperty("login");
		String password = properties.getProperty("password");

		moveEntityFromXmlToDB(
				"Bicycles",
				new XMLBicycleDAO(),
				new MySqlBicycleDAO(url, login, password)
		);
		moveEntityFromXmlToDB(
				"Buses",
				new XMLBusDAO(),
				new MySqlBusDAO(url, login, password)
		);
		moveEntityFromXmlToDB(
				"Electro Cars",
				new XMLElectroCarDAO(),
				new MySqlElectroCarDAO(url, login, password)
		);
		moveEntityFromXmlToDB(
				"Fuel Cars",
				new XMLFuelCarDAO(),
				new MySqlFuelCarDAO(url, login, password)
		);
		moveEntityFromXmlToDB(
				"Houses on Wheels",
				new XMLHouseOnWheelsDAO(),
				new MySqlHouseOnWheelsDAO(url, login, password)
		);
		moveEntityFromXmlToDB(
				"Minibuses",
				new XMLMinibusDAO(),
				new MySqlMinibusDAO(url, login, password)
		);
		moveEntityFromXmlToDB(
				"Trailers",
				new XMLTrailerDAO(),
				new MySqlTrailerDAO(url, login, password)
		);
	}

	private static <T> void moveEntityFromXmlToDB(String entityName, XmlDAO<T, ?> xmlDAO, MySqlDAO<T> mySqlDAO) {
		List<T> xmlData = xmlDAO.read();
		logger.info("Read " + entityName + " from XML: " + xmlData.size());

		mySqlDAO.clear();
		mySqlDAO.save(xmlData);
		logger.info("Saved " + entityName + " to DB: " + mySqlDAO.read());
	}

	private static void saveDataToXml() {
		saveEntityToXml(
				"Bicycles",
				new XMLBicycleDAO(),
				DefaultData.getBicycles()
		);
		saveEntityToXml(
				"Buses",
				new XMLBusDAO(),
				DefaultData.getBuses()
		);
		saveEntityToXml(
				"Electro Cars",
				new XMLElectroCarDAO(),
				DefaultData.getElectroCars()
		);
		saveEntityToXml(
				"Fuel Cars",
				new XMLFuelCarDAO(),
				DefaultData.getFuelCars()
		);
		saveEntityToXml(
				"Houses on Wheels",
				new XMLHouseOnWheelsDAO(),
				DefaultData.getHousesOnWheels()
		);
		saveEntityToXml(
				"Minibuses",
				new XMLMinibusDAO(),
				DefaultData.getMinibuses()
		);
		saveEntityToXml(
				"Trailers",
				new XMLTrailerDAO(),
				DefaultData.getTrailers()
		);
	}

	private static <T> void saveEntityToXml(String entityName, XmlDAO<T, ?> xmlDAO, List<T> data) {
		xmlDAO.save(data);
		logger.info("Saved " + entityName + " to XML: " + xmlDAO.read());
	}
}
