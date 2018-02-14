package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Vehicle;

public class VehicleDao {

	public static void saveToDB(Connection c, Vehicle vehicle) throws SQLException {
		if (vehicle.getId() == 0) {
			String sql = "insert into vehicles (brand, model, year, reg_number, next_service, customer_id) values (?, ?, ?, ?, ?, ?)";
			String generatedColumns[] = { "id" };
			PreparedStatement PreparedStatement;
			PreparedStatement = c.prepareStatement(sql, generatedColumns);

			PreparedStatement.setString(1, vehicle.getBrand());
			PreparedStatement.setString(2, vehicle.getModel());
			PreparedStatement.setInt(3, vehicle.getYear());
			PreparedStatement.setString(4, vehicle.getReg_number());
			PreparedStatement.setDate(5, vehicle.getNext_service());
			PreparedStatement.setInt(6, vehicle.getCustomer_id());
			PreparedStatement.executeUpdate();

			ResultSet rs = PreparedStatement.getGeneratedKeys();
			if (rs.next()) {
				vehicle.setId(rs.getInt(1));
			}

		} else {
			String sql = "update vehicles set brand=?, model=?, year=?, reg_number=?, next_service=?, customer_id=? where id=?;";
			PreparedStatement PreparedStatement;
			PreparedStatement = c.prepareStatement(sql);
			PreparedStatement.setString(1, vehicle.getBrand());
			PreparedStatement.setString(2, vehicle.getModel());
			PreparedStatement.setInt(3, vehicle.getYear());
			PreparedStatement.setString(4, vehicle.getReg_number());
			PreparedStatement.setDate(5, vehicle.getNext_service());
			PreparedStatement.setInt(6, vehicle.getCustomer_id());
			PreparedStatement.executeUpdate();
		}
	}

	public static Vehicle loadById(Connection c, int id) throws SQLException {
		String sql = "select * from vehicles where id = ?";
		PreparedStatement PreparedStatement;
		PreparedStatement = c.prepareStatement(sql);
		PreparedStatement.setInt(1, id);
		ResultSet rs = PreparedStatement.executeQuery();

		if (rs.next()) {
			Vehicle loadedVehicle = new Vehicle();
			loadedVehicle.setId(rs.getInt("id"));
			loadedVehicle.setBrand(rs.getString("brand"));
			loadedVehicle.setModel(rs.getString("model"));
			loadedVehicle.setYear(rs.getInt("year"));
			loadedVehicle.setReg_number(rs.getString("reg_number"));
			loadedVehicle.setNext_service(rs.getDate("next_service"));
			loadedVehicle.setCustomer_id(rs.getInt("customer_id"));
			return loadedVehicle;
		}
		return null;
	}

	public static ArrayList<Vehicle> loadAll(Connection c) throws SQLException {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		String sql = "select * from vehicles";
		PreparedStatement PreparedStatement;
		PreparedStatement = c.prepareStatement(sql);
		ResultSet rs = PreparedStatement.executeQuery();

		while (rs.next()) {
			Vehicle loadedVehicle = new Vehicle();
			loadedVehicle.setId(rs.getInt("id"));
			loadedVehicle.setBrand(rs.getString("brand"));
			loadedVehicle.setModel(rs.getString("model"));
			loadedVehicle.setYear(rs.getInt("year"));
			loadedVehicle.setReg_number(rs.getString("reg_number"));
			loadedVehicle.setNext_service(rs.getDate("next_service"));
			loadedVehicle.setCustomer_id(rs.getInt("customer_id"));
			vehicles.add(loadedVehicle);
		}

		return vehicles;
	}

	public static void delete(Connection c, Vehicle vehicle) throws SQLException {
		if (vehicle.getId() != 0) {
			String sql = "delete from vehicles where id = ?";
			PreparedStatement PreparedStatement;
			PreparedStatement = c.prepareStatement(sql);
			PreparedStatement.setInt(1, vehicle.getId());
			PreparedStatement.executeUpdate();
			vehicle.setId(0);
		}
	}
}
