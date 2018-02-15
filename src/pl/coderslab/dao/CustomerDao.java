package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Customer;

public class CustomerDao {

	public static void saveToDB(Connection c, Customer customer) throws SQLException {
		if (customer.getId() == 0) {
			String sql = "INSERT INTO customers (firstname, surname, birthday) VALUES (?,?,?);";
			String generatedColumns[] = { "id" };
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(sql, generatedColumns);

			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getSurname());
			preparedStatement.setDate(3, customer.getBirthday());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				customer.setId(rs.getInt(1));
			}
			preparedStatement.close();
		} else {
			String sql = "UPDATE customers SET firstname=?, surname=?, birthday=? where id = ?";

			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getSurname());
			preparedStatement.setDate(3, customer.getBirthday());
			preparedStatement.setInt(4, customer.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
	}

	public static Customer loadById(Connection c, int id) throws SQLException {
		String sql = "select * from customers where id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = c.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			Customer loadedCustomer = new Customer();
			loadedCustomer.setId(rs.getInt("id"));
			loadedCustomer.setFirstname(rs.getString("firstname"));
			loadedCustomer.setSurname(rs.getString("surname"));
			loadedCustomer.setBirthday(rs.getDate("birthday"));
			return loadedCustomer;
		}
		return null;
	}

	public static ArrayList<Customer> loadAll(Connection c) throws SQLException {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String sql = "select * from customers";
		PreparedStatement preparedStatement;
		preparedStatement = c.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Customer loadedCustomer = new Customer();
			loadedCustomer.setId(rs.getInt("id"));
			loadedCustomer.setFirstname(rs.getString("firstname"));
			loadedCustomer.setSurname(rs.getString("surname"));
			loadedCustomer.setBirthday(rs.getDate("birthday"));
			customers.add(loadedCustomer);
		}

		return customers;
	}

	public static void delete(Connection c, Customer customer) throws SQLException {
		if (customer.getId() != 0) {
			String sql = "delete from customers where id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.executeUpdate();
			customer.setId(0);
		}
	}
}
