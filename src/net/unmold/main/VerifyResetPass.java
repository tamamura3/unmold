package net.unmold.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.unmold.dao.GetMailByTokenDAO;
import net.unmold.dao.VerifyTokenTimeDAO;

//パスワード再設定メールから実行される

@WebServlet("/VerifyResetPass")
public class VerifyResetPass extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		//tokenと時間の判定
		String token = request.getParameter("verify");

		VerifyTokenTimeDAO verifyTokenTimeDAO = new VerifyTokenTimeDAO();
		boolean result = verifyTokenTimeDAO.verifyTokenAndTime(token);


		//もしtokenと時間がオッケーならパスワード再発行画面に遷移
		if(result) {
			//tokenからメールアドレスをゲット
			GetMailByTokenDAO getMailByTokenDAO = new GetMailByTokenDAO();
			String mail = getMailByTokenDAO.getMailByTokenDAO(token);

			//メアドをセッションに格納
			HttpSession session = request.getSession();
			session.setAttribute("mail", mail);

			//パスワード入力画面へ遷移
			String forwardUrl = "/confirm-new-password";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		}else {

			//認証失敗画面へ遷移
			String forwardUrl = "/verified-result";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		}
	}
}
