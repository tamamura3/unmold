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
import net.unmold.dao.InsertReviewDAO;

//レビューを格納

@WebServlet("/WriteReviewLogic")
public class WriteReviewLogic extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ユーザー情報をゲット
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedIn");

		//formの入力をゲット
		String text = request.getParameter("text");
		int challengeId = Integer.parseInt(request.getParameter("challengeId"));

		//レビューをDBに格納
		InsertReviewDAO insertReviewDAO = new InsertReviewDAO();
		insertReviewDAO.insertReview(user.getId(), challengeId, text);

		String forwardUrl = "/review-submitted";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);

	}

}
