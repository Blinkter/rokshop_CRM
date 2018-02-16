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

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;
import pl.coderslab.service.DbUtil;

/**
 * Servlet implementation class VehicleEdit
 */
@WebServlet("/vehicleEdit")
public class VehicleEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleEdit() {
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
			getServletContext().getRequestDispatcher("/WEB-INF/views/vehicleEdit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			
			String brand = request.getParameter("brand");
			String model = request.getParameter("model");
			int year = Integer.parseInt(request.getParameter("year"));
			String regNumber = request.getParameter("regNumber");
			String nextS = request.getParameter("nextService");
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(nextS);
			Date nextService = new java.sql.Date(date.getTime());
			
			Vehicle vehicle = new Vehicle(brand,model,year,regNumber,nextService,customerId);
			
			Connection c = DbUtil.getConn();
			vehicle.setId(id);
			VehicleDao.saveToDB(c ,vehicle);
			
			getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp").forward(request, response);

		} catch (SQLException | ParseException e1) {
			e1.printStackTrace();
		}
	}

}
