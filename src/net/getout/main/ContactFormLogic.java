package net.getout.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContactFormLogic")
public class ContactFormLogic extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String text = request.getParameter("text");

		//問い合わせ内容を自分宛にメールする
		SendContactToMail sendContactToMail = new SendContactToMail();
		sendContactToMail.sendContactToMail(name, mail, text);

		String forwardUrl = "/about.jsp?contact=true";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);

	}
}
