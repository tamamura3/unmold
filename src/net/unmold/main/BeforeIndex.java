package net.unmold.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.unmold.beans.Challenge;
import net.unmold.dao.BeforeIndexDAO;

public class BeforeIndex extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BeforeIndexDAO beforeIndexDAO = new BeforeIndexDAO();
		List<Challenge> list = beforeIndexDAO.getChallenge();

		request.setAttribute("list", list);
		String forwardUrl = "/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}
}
