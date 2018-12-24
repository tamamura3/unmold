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
import net.getout.dao.MailValidate;
import net.getout.dao.UpdateUserInfoDAO;
import net.getout.dao.ValidateRegisteredUserDAO;

@WebServlet("/EditMailLogic")
public class EditMailLogic extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedIn");
		String password = request.getParameter("passwordForEditMail");
		String mail = request.getParameter("mail");

		ValidateRegisteredUserDAO validateRegisterdUserDAO = new ValidateRegisteredUserDAO();
		boolean registered = validateRegisterdUserDAO.validateRegisteredUser(user.getId(), password);
		//		もし登録されていたらif内実行
		if (registered) {
			MailValidate mailvalidate = new MailValidate();
			boolean mailAlreadyInUse = mailvalidate.mailAlreadyInUse(mail);
			//			もしメールアドレスが使われていなければif内を実行
			if (mailAlreadyInUse != true) {
				UpdateUserInfoDAO updateUserInfoDAO = new UpdateUserInfoDAO();
				updateUserInfoDAO.updateMail(user.getId(), password, mail);

				session.removeAttribute("loggedIn");
				String forwardUrl = "/login?update=success";
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
				dispatcher.forward(request, response);
			}else {
				String forwardUrl = "/edit-info?update=failure";
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
				dispatcher.forward(request, response);
			}
		} else {
			String forwardUrl = "/edit-info?update=failure";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		}
	}
}
