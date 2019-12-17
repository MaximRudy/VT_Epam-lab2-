package com.epam.rudy.repository.mysqldao;

import com.epam.rudy.entity.CarBodyType;
import com.epam.rudy.entity.ElectroCar;
import com.epam.rudy.entity.VehicleType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MySqlElectroCarDAO extends MySqlDAO<ElectroCar> {

	public MySqlElectroCarDAO(String url, String login, String password) {
		super(url, login, password);
	}

	@Override
	public String getTableName() {
		return "electrocar";
	}

	@Override
	public List<String> getFields() {
		return Arrays.asList("id", "vehicleType", "model", "yearOfManufacture", "enginePower",
				"carBodyType", "timeToCharge");
	}

	@Override
	void fillPreparedStatement(PreparedStatement preparedStatement, ElectroCar object) throws SQLException {
		preparedStatement.setString(1, object.getId());
		preparedStatement.setString(2, object.getVehicleType().name());
		preparedStatement.setString(3, object.getModel());
		preparedStatement.setInt(4, object.getYearOfManufacture());
		preparedStatement.setInt(5, object.getEnginePower());
		preparedStatement.setString(6, object.getCarBodyType().name());
		preparedStatement.setInt(7, object.getTimeToCharge());
	}

	@Override
	ElectroCar toObject(ResultSet resultSet) throws SQLException {
		return new ElectroCar(
				resultSet.getString(1),
				VehicleType.valueOf(resultSet.getString(2)),
				resultSet.getString(3),
				resultSet.getInt(4),
				resultSet.getInt(5),
				CarBodyType.valueOf(resultSet.getString(6)),
				resultSet.getInt(7)
		);
	}
}
