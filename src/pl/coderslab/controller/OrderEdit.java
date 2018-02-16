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
 * Servlet implementation class OrderEdit
 */
@WebServlet("/orderEdit")
public class OrderEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			Connection c = DbUtil.getConn();
			Order order = OrderDao.loadById(c, id);
			request.setAttribute("order", order);
			ArrayList<Employee> employees = EmployeeDao.loadAll(c);
			request.setAttribute("employees", employees);
			ArrayList<Vehicle> vehicles = VehicleDao.loadAll(c);
			request.setAttribute("vehicles", vehicles);
			getServletContext().getRequestDispatcher("/WEB-INF/views/orderEdit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("id"));	
			
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
			System.out.println(order);
			Connection c = DbUtil.getConn();
			order.setId(id);
			OrderDao.saveToDB(c ,order);
			} catch (SQLException | ParseException e1) {
				e1.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp")
			.forward(request, response);
	}

}
