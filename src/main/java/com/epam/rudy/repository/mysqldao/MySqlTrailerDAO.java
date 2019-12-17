package com.epam.rudy.repository.mysqldao;

import com.epam.rudy.entity.Trailer;
import com.epam.rudy.entity.VehicleType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MySqlTrailerDAO extends MySqlDAO<Trailer> {

	public MySqlTrailerDAO(String url, String login, String password) {
		super(url, login, password);
	}

	@Override
	public String getTableName() {
		return "trailer";
	}

	@Override
	public List<String> getFields() {
		return Arrays.asList("id", "vehicleType", "model", "yearOfManufacture", "isIndependentVehicle");
	}

	@Override
	void fillPreparedStatement(PreparedStatement preparedStatement, Trailer object) throws SQLException {
		preparedStatement.setString(1, object.getId());
		preparedStatement.setString(2, object.getVehicleType().name());
		preparedStatement.setString(3, object.getModel());
		preparedStatement.setInt(4, object.getYearOfManufacture());
		preparedStatement.setBoolean(5, object.isIndependentVehicle());
	}

	@Override
	Trailer toObject(ResultSet resultSet) throws SQLException {
		return new Trailer(
				resultSet.getString(1),
				VehicleType.valueOf(resultSet.getString(2)),
				resultSet.getString(3),
				resultSet.getInt(4),
				resultSet.getBoolean(5)
		);
	}
}
