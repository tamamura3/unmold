package net.getout.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MailVerified")
public class MailVerified extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String token = request.getParameter("verify");
		ValidateToken validateToken = new ValidateToken();
		boolean rs = validateToken.excuteValidation(token);
		if (rs) {

			String forwardUrl = "/verified";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		} else {
			String forwardUrl = "/verified-result";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		}

	}

}
