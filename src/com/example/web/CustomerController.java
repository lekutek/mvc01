package com.example.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.CoffeeExpert;
import com.example.model.Customer;
import com.example.model.DAOData;
import com.example.model.DAODataImplementation;
import com.example.model.Trip;

/**
 * Servlet implementation class CustomerController
 */
// @WebServlet("/CustomerController")
@WebServlet(name = "CustomerController", urlPatterns = { "/controller" })
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAOData cm = new DAODataImplementation();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Customer> kc = new ArrayList<Customer>();
		List<Trip> kt = new ArrayList<Trip>();

		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		if (request.getParameter("id") != null) {
			if (request.getParameter("delete").equals("customers")) {
				cm.removeCustomer(Integer.parseInt(request.getParameter("id")));
			}
			if (request.getParameter("delete").equals("trips")) {
				cm.removeTrip(Integer.parseInt(request.getParameter("id")));
			}
		}

		if (request.getParameter("form") != null) {
			if (request.getParameter("form").equals("customers")) {
				cm.addCustomer(new Customer(0, request.getParameter("name"),
						request.getParameter("surname"), request
								.getParameter("address"), request
								.getParameter("phone")));
			}
			if (request.getParameter("form").equals("trips")) {
				cm.addTrip(new Trip(0, request.getParameter("destination"),
						request.getParameter("startDate"), request
								.getParameter("endDate"), request
								.getParameter("price"), request
								.getParameter("discount")));
			}
		}

		kc = cm.getAllCustomers();
		request.setAttribute("customers", kc);
		kt = cm.getAllTrips();
		request.setAttribute("trips", kt);

		if (request.getParameter("page") != null) {
			if (request.getParameter("page").equals("customers")) {
				RequestDispatcher widok = request
						.getRequestDispatcher("customers.jsp");
				widok.forward(request, response);
			}
			if (request.getParameter("page").equals("trips")) {
				RequestDispatcher widok = request
						.getRequestDispatcher("trips.jsp");
				widok.forward(request, response);
			}

		}

	}

}
