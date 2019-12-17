package com.epam.rudy.repository.mysqldao;

import com.epam.rudy.repository.SimpleDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MySqlDAO<T> implements SimpleDAO<T> {

	private static Logger logger = LogManager.getLogger();

	private String url;
	private String login;
	private String password;

	public MySqlDAO(String url, String login, String password) {
		this.url = url;
		this.login = login;
		this.password = password;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.fatal(e.toString());
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, login, password);
	}

	public abstract String getTableName();

	public abstract List<String> getFields();

	abstract void fillPreparedStatement(PreparedStatement preparedStatement, T object) throws SQLException;

	abstract T toObject(ResultSet resultSet) throws SQLException;

	@Override
	public void save(List<T> objects) {
		objects.forEach(obj -> {
			try (Connection connection = getConnection()) {
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO `" + getTableName() + "` (" +
								getFields().stream()
										.map(x -> '`' + x + '`')
										.collect(Collectors.joining(", ")) + ") VALUES " +
								getFields().stream()
										.map(x -> "?")
										.collect(Collectors.joining(",", "(", ")")) + ';');
				fillPreparedStatement(preparedStatement, obj);
				preparedStatement.execute();
			} catch (SQLException e) {
				logger.error(e.toString());
			}
		});
	}

	@Override
	public List<T> read() {
		List<T> list = new ArrayList<>();
		try (Connection connection = getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT " + getFields().stream()
							.map(x -> '`' + x + '`')
							.collect(Collectors.joining(", ")) + " FROM " + getTableName() + ';');
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				list.add(toObject(resultSet));
			}
		} catch (SQLException e) {
			logger.error(e.toString());
		}
		return list;
	}

	public void clear() {
		try (Connection connection = getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + getTableName());
			preparedStatement.execute();
		} catch (SQLException exc) {
			logger.error(exc.toString());
		}
	}
}
