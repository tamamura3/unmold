package net.getout.main;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

import net.getout.beans.User;
import net.getout.dao.GetUserInfo;
import net.getout.dao.LoginDAO;

@WebServlet("/LoginLogic")
public class LoginLogic extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mail = StringEscapeUtils.escapeHtml(request.getParameter("mail"));
		String password = StringEscapeUtils.escapeHtml(request.getParameter("password"));


		LoginDAO loginDAO = new LoginDAO();
		boolean loginResult = loginDAO.loginValidate(mail, password);

		//trueならユーザー情報をゲットしてセッションに保
		//falseならloginfail=trueをパラメータに渡してログイン画面に戻す（trueを渡すと、パスかメールが間違っていますと表示される）
		if (loginResult) {
			GetUserInfo getUserInfo = new GetUserInfo();
			User loginUser = getUserInfo.GetUser(mail, password);

			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", loginUser);
			response.sendRedirect("/GetOut/top");
		} else {
			String forwardUrl = "/login?loginfail=true";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		}

	}
}
