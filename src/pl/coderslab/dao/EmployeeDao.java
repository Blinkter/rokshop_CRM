package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Employee;

public class EmployeeDao {

	public static void saveToDB(Connection c, Employee employee) throws SQLException {
		if (employee.getId() == 0) {
			String sql = "insert into employees (firstname, surname, address, phone_number, note, hour_rate) values (?, ?, ?, ?, ?, ?)";
			String generatedColumns[] = { "id" };
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(sql, generatedColumns);

			preparedStatement.setString(1, employee.getFirstname());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setInt(4, employee.getPhone_number());
			preparedStatement.setString(5, employee.getNote());
			preparedStatement.setDouble(6, employee.getHour_rate());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				employee.setId(rs.getInt(1));
			}

		} else {
			String sql = "update employees set firstname=?, surname=?, address=?, phone_number=?, note=?, hour_rate=? where id=?;";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(sql);
			preparedStatement.setString(1, employee.getFirstname());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setInt(4, employee.getPhone_number());
			preparedStatement.setString(5, employee.getNote());
			preparedStatement.setDouble(6, employee.getHour_rate());
			preparedStatement.setDouble(7, employee.getId());
			preparedStatement.executeUpdate();
		}
	}

	public static Employee loadById(Connection c, int id) throws SQLException {
		String sql = "select * from employees where id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = c.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			Employee loadedEmployee = new Employee();
			loadedEmployee.setId(rs.getInt("id"));
			loadedEmployee.setFirst_name(rs.getString("firstname"));
			loadedEmployee.setSurname(rs.getString("surname"));
			loadedEmployee.setAddress(rs.getString("address"));
			loadedEmployee.setPhone_number(rs.getInt("phone_number"));
			loadedEmployee.setNote(rs.getString("note"));
			loadedEmployee.setHour_rate(rs.getDouble("hour_rate"));
			return loadedEmployee;
		}
		return null;
	}

	public static ArrayList<Employee> loadAll(Connection c) throws SQLException {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String sql = "select * from employees";
		PreparedStatement preparedStatement;
		preparedStatement = c.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Employee loadedEmployee = new Employee();
			loadedEmployee.setId(rs.getInt("id"));
			loadedEmployee.setFirst_name(rs.getString("firstname"));
			loadedEmployee.setSurname(rs.getString("surname"));
			loadedEmployee.setAddress(rs.getString("address"));
			loadedEmployee.setPhone_number(rs.getInt("phone_number"));
			loadedEmployee.setNote(rs.getString("note"));
			loadedEmployee.setHour_rate(rs.getDouble("hour_rate"));
			employees.add(loadedEmployee);
		}

		return employees;
	}

	public static void delete(Connection c, Employee employee) throws SQLException {
		if (employee.getId() != 0) {
			String sql = "delete from employees where id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.executeUpdate();
			employee.setId(0);
		}
	}

}
