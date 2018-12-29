package net.unmold.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.unmold.beans.User;
import net.unmold.dao.DeleteReviewDAO;

@WebServlet("/DeleteReview")
public class DeleteReview extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedIn");

		int challengeId = Integer.parseInt(request.getParameter("challenge"));

		DeleteReviewDAO deleteReviewDAO = new DeleteReviewDAO();
		deleteReviewDAO.deleteReview(user.getId(), challengeId);

		String forwardUrl = "/review-deleted";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}
}
