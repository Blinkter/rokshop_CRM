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
 * Servlet implementation class VehicleAdd
 */
@WebServlet("/vehicleAdd")
public class VehicleAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("customerId", customerId);
		getServletContext().getRequestDispatcher("/WEB-INF/views/vehicleAdd.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			int customerId = Integer.parseInt(request.getParameter("id"));
			String brand = request.getParameter("brand");
			String model = request.getParameter("model");
			int year = Integer.parseInt(request.getParameter("year"));
			String regNumber = request.getParameter("regNumber");
			String nextS = request.getParameter("nextService");
			
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(nextS);
			Date nextService = new java.sql.Date(date.getTime());
			
			Vehicle vehicle = new Vehicle(brand,model,year,regNumber,nextService,customerId);
			
			Connection c = DbUtil.getConn();
			VehicleDao.saveToDB(c ,vehicle);
			} catch (SQLException | ParseException e1) {
				e1.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/WEB-INF/views/changesSaved.jsp")
			.forward(request, response);
			
		}
}
