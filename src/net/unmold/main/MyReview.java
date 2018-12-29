package net.unmold.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.unmold.beans.Challenge;
import net.unmold.beans.Reviews;
import net.unmold.beans.User;
import net.unmold.dao.GetChallengeDAO;
import net.unmold.dao.GetReviewDAO;

@WebServlet("/MyReview")
public class MyReview  extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedIn");
	    Integer challengeId = Integer.parseInt(request.getParameter("number"));
	    System.out.println(challengeId);

//チャレンジを取得
	    GetChallengeDAO getChallengeDAO = new GetChallengeDAO();
	    Challenge challenge = getChallengeDAO.getChallenge(challengeId);
	    System.out.println(challenge.getChallengeName());
	    session.setAttribute("challenge", challenge);

//	    レビュー内容を取得
	    GetReviewDAO getReviewDAO = new GetReviewDAO();
	    Reviews review = getReviewDAO.getSingleReview(user.getId(), challengeId);
	    System.out.println(review.getText());
	    session.setAttribute("review", review);

	    String forwardUrl = "/my-review";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);

}}
