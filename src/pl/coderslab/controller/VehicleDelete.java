package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;
import pl.coderslab.service.DbUtil;

/**
 * Servlet implementation class vehicleDelete
 */
@WebServlet("/vehicleDelete")
public class VehicleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleDelete() {
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
			Vehicle vehicle = VehicleDao.loadById(c, id);
			request.setAttribute("vehicle", vehicle);
			getServletContext().getRequestDispatcher("/WEB-INF/views/vehicleDelete.jsp").forward(request, response);
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
			
			Vehicle vehicle = new Vehicle();
			vehicle.setId(id);
			VehicleDao.delete(c,vehicle);
			getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
