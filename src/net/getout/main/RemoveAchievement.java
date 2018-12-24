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
import net.getout.dao.RemoveAchievementDAO;

//
@WebServlet("/RemoveAchievement")
public class RemoveAchievement extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		int challengeId = Integer.parseInt(request.getParameter("number"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedIn");

		RemoveAchievementDAO removeAchievementDAO = new RemoveAchievementDAO();
		removeAchievementDAO.removeAchievement(user.getId(), challengeId);

		String forwardUrl = "/MyPageLogic";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}

}
