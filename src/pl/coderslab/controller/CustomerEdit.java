package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;
import pl.coderslab.service.DbUtil;

/**
 * Servlet implementation class CustomerEdit
 */
@WebServlet("/customerEdit")
public class CustomerEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Connection c = DbUtil.getConn();
			Customer customer = CustomerDao.loadById(c, id);
			request.setAttribute("customer", customer);
			getServletContext().getRequestDispatcher("/WEB-INF/views/customerEdit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			String firstname = request.getParameter("firstname");
			String surname = request.getParameter("surname");
			String bDay = request.getParameter("birthday");

			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(bDay);
			Date birthday = new java.sql.Date(date.getTime());
			Customer customer = new Customer(firstname, surname, birthday);
			Connection c = DbUtil.getConn();
			customer.setId(id);
			CustomerDao.saveToDB(c, customer);

			getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp").forward(request, response);

		} catch (SQLException | ParseException e1) {
			e1.printStackTrace();
		}
	}

}
