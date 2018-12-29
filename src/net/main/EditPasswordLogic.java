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
import net.unmold.dao.UpdateUserInfoDAO;
import net.unmold.dao.ValidateRegisteredUserDAO;

@WebServlet("/EditPasswordLogic")
public class EditPasswordLogic extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedIn");
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");

		ValidateRegisteredUserDAO validateRegisterdUserDAO = new ValidateRegisteredUserDAO();
		boolean registered = validateRegisterdUserDAO.validateRegisteredUser(user.getId(), currentPassword);

		//登録が確認できたらアップデートする
		if(registered) {
			UpdateUserInfoDAO updateUserInfoDAO = new UpdateUserInfoDAO();
			updateUserInfoDAO.updatePassword(user.getId(), currentPassword, newPassword);

			String forwardUrl = "/login?update=success2";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		}else {
			String forwardUrl = "/edit-info?update=failure2";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		}


	}
}
