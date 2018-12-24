package net.getout.main;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.getout.beans.Achievement;
import net.getout.beans.User;
import net.getout.dao.GetAchievementListDAO;

@WebServlet("/MyPageLogic")
public class MyPageLogic extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		//userIdをゲット
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedIn");

		//そのuserIdのAchievementリストをゲット
		GetAchievementListDAO getAchievementListDAO = new GetAchievementListDAO();
		List<Achievement> achievementList = getAchievementListDAO.getAchievementList(user.getId());

		//achievementリストをセッションに格納
		session.setAttribute("achievementList", achievementList);

		String forwardUrl = "/mypage";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
