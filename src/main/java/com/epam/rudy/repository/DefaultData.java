package com.epam.rudy.repository;

import com.epam.rudy.entity.*;

import java.util.Arrays;
import java.util.List;

public class DefaultData {

	public static List<Bicycle> getBicycles() {
		Bicycle bicycle1 = new Bicycle(
				"1",
				VehicleType.BICYCLE,
				"bicycle1",
				2017,
				true
		);
		return Arrays.asList(bicycle1);
	}

	public static List<Bus> getBuses() {
		Bus bus1 = new Bus(
				"1",
				VehicleType.BUS,
				"bus1",
				2010,
				700,
				CarBodyType.WAGON,
				10,
				4
		);
		return Arrays.asList(bus1);
	}

	public static List<ElectroCar> getElectroCars() {
		ElectroCar electroCar1 = new ElectroCar(
				"1",
				VehicleType.ELECTRO_CAR,
				"electro-car1",
				2015,
				200,
				CarBodyType.SEDAN,
				3
		);
		return Arrays.asList(electroCar1);
	}

	public static List<FuelCar> getFuelCars() {
		FuelCar fuelCar1 = new FuelCar(
				"1",
				VehicleType.FUEL_CAR,
				"fuel-car1",
				2012,
				300,
				CarBodyType.HATCHBACK,
				5
		);
		return Arrays.asList(fuelCar1);
	}

	public static List<HouseOnWheels> getHousesOnWheels() {
		HouseOnWheels houseOnWheels1 = new HouseOnWheels(
				"1",
				VehicleType.HOUSE_ON_WHEELS,
				"house-on-wheels1",
				2016,
				600,
				CarBodyType.WAGON,
				8,
				true
		);
		return Arrays.asList(houseOnWheels1);
	}

	public static List<Minibus> getMinibuses() {
		Minibus minibus1 = new Minibus(
				"1",
				VehicleType.MINIBUS,
				"minibus1",
				2008,
				500,
				CarBodyType.WAGON,
				6
		);
		return Arrays.asList(minibus1);
	}

	public static List<Trailer> getTrailers() {
		Trailer trailer1 = new Trailer(
				"1",
				VehicleType.TRAILER,
				"trailer1",
				2005,
				true
		);
		return Arrays.asList(trailer1);
	}
}
