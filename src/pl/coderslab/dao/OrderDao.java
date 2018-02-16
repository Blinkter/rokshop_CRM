package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;

public class OrderDao {

	public static void saveToDB(Connection c, Order order) throws SQLException {
		if (order.getId() == 0) {
			String sql = "insert into orders (accepted, planned_begin, begin, order_employee_id, problem_description, repair_description,"
					+ " order_vehicle_id, status, repair_cost_for_customer, parts_cost, hours_amount) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String generatedColumns[] = { "id" };
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(sql, generatedColumns);

			preparedStatement.setDate(1, order.getAccepted());
			preparedStatement.setDate(2, order.getPlanned_begin());
			preparedStatement.setDate(3, order.getBegin());
			preparedStatement.setInt(4, order.getOrder_employee_id());
			preparedStatement.setString(5, order.getProblem_description());
			preparedStatement.setString(6, order.getRepair_description());
			preparedStatement.setInt(7, order.getOrder_vehicle_id());
			preparedStatement.setString(8, order.getStatus());
			preparedStatement.setDouble(9, order.getRepair_cost_for_customer());
			preparedStatement.setDouble(10, order.getParts_cost());
			preparedStatement.setDouble(11, order.getHours_amount());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				order.setId(rs.getInt(1));
			}

		} else {
			String sql = "update orders set accepted=?, planned_begin=?, begin=?, order_employee_id=?, problem_description=?, repair_description=?, "
					+ "order_vehicle_id=?, status=?, repair_cost_for_customer=?, parts_cost=?, hours_amount=? where id=?;";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(sql);
			preparedStatement.setDate(1, order.getAccepted());
			preparedStatement.setDate(2, order.getPlanned_begin());
			preparedStatement.setDate(3, order.getBegin());
			preparedStatement.setInt(4, order.getOrder_employee_id());
			preparedStatement.setString(5, order.getProblem_description());
			preparedStatement.setString(6, order.getRepair_description());
			preparedStatement.setInt(7, order.getOrder_vehicle_id());
			preparedStatement.setString(8, order.getStatus());
			preparedStatement.setDouble(9, order.getRepair_cost_for_customer());
			preparedStatement.setDouble(10, order.getParts_cost());
			preparedStatement.setDouble(11, order.getHours_amount());
			preparedStatement.setInt(12, order.getId());
			preparedStatement.executeUpdate();
		}
	}

	public static Order loadById(Connection c, int id) throws SQLException {
		String sql = "select * from orders where id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = c.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			Order loadedOrder = new Order();
			loadedOrder.setId(rs.getInt("id"));
			loadedOrder.setAccepted(rs.getDate("accepted"));
			loadedOrder.setPlanned_begin(rs.getDate("planned_begin"));
			loadedOrder.setBegin(rs.getDate("begin"));
			loadedOrder.setOrder_employee_id(rs.getInt("order_employee_id"));
			loadedOrder.setProblem_description(rs.getString("problem_description"));
			loadedOrder.setRepair_description(rs.getString("repair_description"));
			loadedOrder.setOrder_vehicle_id(rs.getInt("order_vehicle_id"));
			loadedOrder.setStatus(rs.getString("status"));
			loadedOrder.setRepair_cost_for_customer(rs.getDouble("repair_cost_for_customer"));
			loadedOrder.setParts_cost(rs.getDouble("parts_cost"));
			loadedOrder.setHours_amount(rs.getDouble("hours_amount"));

			return loadedOrder;
		}
		return null;
	}

	public static ArrayList<Order> loadAll(Connection con) throws SQLException {
		ArrayList<Order> orders = new ArrayList<Order>();
		String sql = "select * from orders";
		PreparedStatement preparedStatement;
		preparedStatement = con.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Order loadedOrder = new Order();
			loadedOrder.setId(rs.getInt("id"));
			loadedOrder.setAccepted(rs.getDate("accepted"));
			loadedOrder.setBegin(rs.getDate("begin"));
			loadedOrder.setOrder_employee_id(rs.getInt("order_employee_id"));
			loadedOrder.setProblem_description(rs.getString("problem_description"));
			loadedOrder.setRepair_description(rs.getString("repair_description"));
			loadedOrder.setOrder_vehicle_id(rs.getInt("order_vehicle_id"));
			loadedOrder.setStatus(rs.getString("status"));
			loadedOrder.setRepair_cost_for_customer(rs.getDouble("repair_cost_for_customer"));
			loadedOrder.setParts_cost(rs.getDouble("parts_cost"));
			loadedOrder.setHours_amount(rs.getDouble("hours_amount"));
			orders.add(loadedOrder);
		}

		return orders;
	}

	
	public static ArrayList<Order> loadAllByStatus(Connection c, String status) throws SQLException{
		ArrayList<Order> orders = new ArrayList<Order>();
		String sql = "select * from orders where status=?";
		PreparedStatement preparedStatement;
		preparedStatement = c.prepareStatement(sql);
		preparedStatement.setString(1, status);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			Order loadedOrder = new Order();
			loadedOrder.setId(rs.getInt("id"));
			loadedOrder.setAccepted(rs.getDate("accepted"));
			loadedOrder.setPlanned_begin(rs.getDate("planned_begin"));
			loadedOrder.setBegin(rs.getDate("begin"));
			loadedOrder.setOrder_employee_id(rs.getInt("order_employee_id"));
			loadedOrder.setProblem_description(rs.getString("problem_description"));
			loadedOrder.setRepair_description(rs.getString("repair_description"));
			loadedOrder.setOrder_vehicle_id(rs.getInt("order_vehicle_id"));
			loadedOrder.setStatus(rs.getString("status"));
			loadedOrder.setRepair_cost_for_customer(rs.getDouble("repair_cost_for_customer"));
			loadedOrder.setParts_cost(rs.getDouble("parts_cost"));
			loadedOrder.setHours_amount(rs.getDouble("hours_amount"));

			orders.add(loadedOrder);
		}
		return orders;
	}
	
	public static ArrayList<Order> loadAllByEmployee(Connection c, Employee employee) throws SQLException{
	
			
		ArrayList<Order> orders = new ArrayList<Order>();
		String sql = "select * from orders where order_employee_id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = c.prepareStatement(sql);
		preparedStatement.setInt(1, employee.getId());
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			Order loadedOrder = new Order();
			loadedOrder.setId(rs.getInt("id"));
			loadedOrder.setAccepted(rs.getDate("accepted"));
			loadedOrder.setPlanned_begin(rs.getDate("planned_begin"));
			loadedOrder.setBegin(rs.getDate("begin"));
			loadedOrder.setOrder_employee_id(rs.getInt("order_employee_id"));
			loadedOrder.setProblem_description(rs.getString("problem_description"));
			loadedOrder.setRepair_description(rs.getString("repair_description"));
			loadedOrder.setOrder_vehicle_id(rs.getInt("order_vehicle_id"));
			loadedOrder.setStatus(rs.getString("status"));
			loadedOrder.setRepair_cost_for_customer(rs.getDouble("repair_cost_for_customer"));
			loadedOrder.setParts_cost(rs.getDouble("parts_cost"));
			loadedOrder.setHours_amount(rs.getDouble("hours_amount"));

			orders.add(loadedOrder);
		}
		return orders;
	}
	
	public static void delete(Connection c, Order order) throws SQLException {
		if (order.getId() != 0) {
			String sql = "delete from orders where id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = c.prepareStatement(sql);
			preparedStatement.setInt(1, order.getId());
			preparedStatement.executeUpdate();
			order.setId(0);
		}
	}

}
