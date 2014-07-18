package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.CoffeeExpert;

@WebServlet(name = "Coffee", urlPatterns = { "/CoffeeSelect.do" })
public class CoffeeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<String> types = new CoffeeExpert().getTypes(request
				.getParameter("taste"));
		request.setAttribute("types", types);
		RequestDispatcher view = request.getRequestDispatcher("coffee.jsp");
		view.forward(request, response);
	}
}
