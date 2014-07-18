package com.example.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
//import org.apache.jasper.compiler.Node.SetProperty;

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
		//Trip to = new Trip();


		if ((request.getParameter("id") != null)
				&& (request.getParameter("delete") != null)) {
			if (request.getParameter("delete").equals("customer")) {
				cm.removeCustomer(Integer.parseInt(request.getParameter("id")));
			}
			if (request.getParameter("delete").equals("trip")) {
				cm.removeTrip(Integer.parseInt(request.getParameter("id")));
			}
		}

		if (request.getParameter("form") != null) {
			if (request.getParameter("form").equals("customers")) {
				cm.addCustomer((Customer)serProperties(new Customer(),request));
//				cm.addCustomer(new Customer(0, request.getParameter("name"),
//						request.getParameter("surname"), request
//								.getParameter("address"), request
//								.getParameter("phone")));
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
				forward(request, response, "customers");
			}
			if (request.getParameter("page").equals("trips")) {
				forward(request, response, "trips");
			}

		}

	}

	private void forward(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher widok = request.getRequestDispatcher(page + ".jsp");
		widok.forward(request, response);
	}
	
	private Object serProperties(Object o, HttpServletRequest request) {
		try {
			BeanUtils.populate(o, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return o;
	}

}
