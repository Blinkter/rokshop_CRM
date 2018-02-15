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
 * Servlet implementation class CustomerAdd
 */
@WebServlet("/customerAdd")
public class CustomerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/customerAdd.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String firstname = request.getParameter("firstname");
			String surname = request.getParameter("surname");

			String bDay = request.getParameter("birthday");

			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(bDay);
			Date birthday = new java.sql.Date(date.getTime());

			Customer customer = new Customer(firstname, surname, birthday);

			Connection c = DbUtil.getConn();
			CustomerDao.saveToDB(c, customer);
		} catch (SQLException | ParseException e1) {
			e1.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp").forward(request, response);

	}

}
