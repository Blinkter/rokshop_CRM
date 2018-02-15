package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;
import pl.coderslab.service.DbUtil;

/**
 * Servlet implementation class EmployeeAdd
 */
@WebServlet("/employeeAdd")
public class EmployeeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/employeeAdd.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		request.setCharacterEncoding("UTF-8");
		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		String note = request.getParameter("note");
		double hourRate = Double.parseDouble(request.getParameter("hourRate"));
		
		Employee employee = new Employee(firstname, surname, address, phoneNumber, note, hourRate);
		response.setCharacterEncoding("UTF-8");
		
		Connection c = DbUtil.getConn();
		EmployeeDao.saveToDB(c ,employee);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp")
		.forward(request, response);
		
	}

}
