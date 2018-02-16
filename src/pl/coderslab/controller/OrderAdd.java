package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;
import pl.coderslab.service.DbUtil;

/**
 * Servlet implementation class OrderAdd
 */
@WebServlet("/orderAdd")
public class OrderAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Connection c = DbUtil.getConn();
			ArrayList<Employee> employees = EmployeeDao.loadAll(c);
			request.setAttribute("employees", employees);
			ArrayList<Vehicle> vehicles = VehicleDao.loadAll(c);
			request.setAttribute("vehicles", vehicles);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/orderAdd.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		
		String dAccepted = request.getParameter("accepted");
		String dPlannedBegin = request.getParameter("planned_begin");
		String dBegin = request.getParameter("begin");
		int employeeId = Integer.parseInt(request.getParameter("order_employee_id"));
		String problemDesc = request.getParameter("problem_description");
		String repairDesc = request.getParameter("repair_description");
		String status = request.getParameter("status");
		int vehicleId = Integer.parseInt(request.getParameter("order_vehicle_id"));
		double repairCost = Double.parseDouble(request.getParameter("repair_cost_for_customer"));
		double partsCost = Double.parseDouble(request.getParameter("parts_cost"));
		int hoursAmount = Integer.parseInt(request.getParameter("hours_amount"));
		
		
		java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dAccepted);
		Date accepted = new java.sql.Date(date.getTime());
		
		date = new SimpleDateFormat("yyyy-MM-dd").parse(dPlannedBegin);
		Date plannedBegin = new java.sql.Date(date.getTime());
		
		date = new SimpleDateFormat("yyyy-MM-dd").parse(dBegin);
		Date begin = new java.sql.Date(date.getTime());
		
		Order order = new Order(accepted, plannedBegin, begin, employeeId, problemDesc, repairDesc, status, vehicleId, repairCost, partsCost, hoursAmount);
		
		Connection c = DbUtil.getConn();
		OrderDao.saveToDB(c ,order);
		} catch (SQLException | ParseException e1) {
			e1.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp")
		.forward(request, response);
	}

}
