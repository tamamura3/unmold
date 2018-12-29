package net.unmold.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.unmold.beans.Challenge;
import net.unmold.beans.Reviews;
import net.unmold.dao.GetChallengeDAO;
import net.unmold.dao.GetReviewDAO;

//indexのチャレンジを押下すると呼ばれるクラス　チャレンジの詳細ページへとリダイレクトする

@WebServlet("/SingleChallengeLogic")
public class SingleChallengeLogic extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int challengeId = Integer.parseInt(request.getParameter("number")); //パラメータを取得してintに変換（stringでしか渡せなかったので）
		GetChallengeDAO getChallengeDAO = new GetChallengeDAO();//チャレンジidからチャレンジのbeansを取得
		Challenge challenge = getChallengeDAO.getChallenge(challengeId);

		GetReviewDAO getReviewDAO = new GetReviewDAO();//チャレンジidからレビューをリストで取得
		ArrayList<Reviews> review = getReviewDAO.getReview(challengeId);

		request.setAttribute("review", review);
		request.setAttribute("challenge", challenge);

		String forwardUrl = "/single-challenge";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);

	}
}
