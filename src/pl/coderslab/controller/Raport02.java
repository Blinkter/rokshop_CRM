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
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.service.DbUtil;

/**
 * Servlet implementation class Raport02
 */
@WebServlet("/raport02")
public class Raport02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Raport02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/raport02.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection c = DbUtil.getConn();
			
			String dStart = request.getParameter("start");
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dStart);
			Date start = new java.sql.Date(date.getTime());
			
			String dEnd = request.getParameter("end");
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dEnd);
			Date end = new java.sql.Date(date.getTime());
			
			request.setAttribute("start", start);
			request.setAttribute("end", end);
			
			ArrayList<Employee> employees = EmployeeDao.loadAll(c);	//lista pracowników
			
			
			double partsCost = 0;		//koszt części
			double customerPayment = 0;			//zapłata od klientów
			double employeesCost = 0;
			
			for (Employee employee : employees) {
				int time = 0;
				double employeeCost = 0;
				ArrayList<Order> allOrders = OrderDao.loadAllByEmployee(c, employee);
				for (Order order : allOrders) {
					String status = order.getStatus();
					Date begin = order.getBegin();
					if ((status.equals("Gotowy")) && (begin.getTime() >= start.getTime()) && (begin.getTime() <= end.getTime())) {
						int orderHours = (int) order.getHours_amount();
						time += orderHours;	
						customerPayment += order.getRepair_cost_for_customer();
						partsCost += order.getParts_cost();
						System.out.println(time);
						System.out.println(customerPayment);
						System.out.println(partsCost);
					} 
				}
				employeeCost=time * employee.getHour_rate();
				employeesCost += employeeCost;
				
			}
			double profit = customerPayment - employeesCost - partsCost;
			profit *= 100;
			profit = Math.round(profit);
			profit /= 100;
			
			request.setAttribute("profit", profit);
			request.setAttribute("employeesCost", employeesCost);
			request.setAttribute("partsCost", partsCost);
			request.setAttribute("customerPayment",customerPayment);
			
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/raport02.jsp").forward(request, response);
	}

}
