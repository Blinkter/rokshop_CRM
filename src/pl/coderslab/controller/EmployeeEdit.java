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
 * Servlet implementation class EmployeeEdit
 */
@WebServlet("/employeeEdit")
public class EmployeeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Connection c;
		try {
			c = DbUtil.getConn();
			Employee employee = EmployeeDao.loadById(c, id);
			request.setAttribute("employee", employee);
			getServletContext().getRequestDispatcher("/WEB-INF/views/employeeEdit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));	
			String firstname = request.getParameter("firstname");
			String surname = request.getParameter("surname");
			String address = request.getParameter("address");
			int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
			String note = request.getParameter("note");
			double hourRate = Double.parseDouble(request.getParameter("hourRate"));
			
			Connection c = DbUtil.getConn();
			Employee employee = new Employee(firstname, surname, address, phoneNumber, note, hourRate);
			employee.setId(id);
			EmployeeDao.saveToDB(c ,employee);
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp")
		.forward(request, response);
	}

}
