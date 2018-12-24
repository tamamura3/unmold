package net.getout.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.getout.beans.User;
import net.getout.dao.AddAchievementDAO;

/*
呼び出し　️singleChallenge.jspの追加ボタン押下時
パラメータで渡されたchallengeIdと、sessionからゲットしたuserIdを使用し、
お気に入り登録済みか確認する
確認後、未なら登録する
終了後はSingleChallengeLogicを通してsingleChallenge.jspに返す
理由　いきなりJSPだとListやsessionなどがnullになってしまう部分があったため
テスト
*/
@WebServlet("/AchieveLogic")
public class AchieveLogic extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//challengeIdとuserインスタンスをゲットする
		int challengeId = Integer.parseInt(request.getParameter("number"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedIn");

		//登録済みでないか確認　⇩未登録の時しか登録ボタンが出てこないので、この処理が行われている時点で未登録確定
		//		AchievementDAO achievement = new AchievementDAO();
		//		boolean isItAlreadyAdded = achievement.validateAdd(user.getId(), challengeId);

		AddAchievementDAO addAchievementDAO = new AddAchievementDAO();
		addAchievementDAO.addAchievement(user.getId(), challengeId);
		String forwardUrl = "/SingleChallengeLogic?number=" + challengeId;
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}
}
/*
 * challengeIdとuserIDをゲット
 int challengeId = Integer.parseInt(request.getParameter("number"));
 HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loggedIn");


 */
