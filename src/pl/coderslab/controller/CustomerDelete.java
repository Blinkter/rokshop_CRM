package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;
import pl.coderslab.service.DbUtil;

/**
 * Servlet implementation class CustomerDelete
 */
@WebServlet("/customerDelete")
public class CustomerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Connection c = DbUtil.getConn();
			Customer customer = CustomerDao.loadById(c, id);
			request.setAttribute("customer", customer);
			getServletContext().getRequestDispatcher("/WEB-INF/views/customerDelete.jsp").forward(request, response);
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
			Connection c = DbUtil.getConn();
			
			Customer customer = new Customer();
			customer.setId(id);
			CustomerDao.delete(c,customer);
			getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
