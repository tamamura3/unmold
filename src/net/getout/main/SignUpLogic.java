package net.getout.main;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import net.getout.dao.MailValidate;
import net.getout.dao.SignUpDAO;

//signupボタン押下後に実行される　tokenを生成しアドレスと一緒にDBに登録　メールを送る

@WebServlet("/SignUpLogic")
public class SignUpLogic extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		try {
			String mail = StringEscapeUtils.escapeHtml(request.getParameter("mail"));
			MailValidate mailValidate = new MailValidate();
			boolean mailAlreadyInUse = mailValidate.mailAlreadyInUse(mail);
			if(mailAlreadyInUse) {

				String forwardUrl = "/signup?inUse=true";
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
				dispatcher.forward(request, response);

			}else {

				String name = StringEscapeUtils.escapeHtml(request.getParameter("name"));
				String password = StringEscapeUtils.escapeHtml(request.getParameter("password"));
				String token = UUID.randomUUID().toString();

				Timestamp date = new Timestamp(System.currentTimeMillis());

				SignUpDAO signUpDAO = new SignUpDAO();
				signUpDAO.setInfo(name, mail, password, token, date);

				SendMail sendMail = new SendMail();
				sendMail.SendMailExecute(mail, token);

				String forwardUrl = "/mail-sent";
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
