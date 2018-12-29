package net.unmold.main;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.unmold.dao.ResetPassDAO;
import net.unmold.dao.ValidateRegisteredUserDAO;

@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		入力メールアドレスを取得
		String mail = request.getParameter("mail");

//		メールアドレスの登録があるか確認
		ValidateRegisteredUserDAO validateRegisteredUserDAO = new ValidateRegisteredUserDAO();
		boolean registered = validateRegisteredUserDAO.validateRegisteredUserByMail(mail);

		if(registered) {

//			登録あればトークンと時間を生成
			String token = UUID.randomUUID().toString();
			Timestamp date = new Timestamp(System.currentTimeMillis());

//			DBに格納する
			ResetPassDAO resetPassDAO = new ResetPassDAO();
			resetPassDAO.resetPass(mail, token, date);

//			メールを送信
			SendMail sendMail = new SendMail();
			sendMail.sendMailForResetPass(mail, token);

//			パラメータ入れてリセット画面に戻す(成功)
			String forwardUrl = "/rest-password?reset=true";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		}else {

//			パラメータ入れてリセット画面に戻す（メールアドレス登録なし）
			String forwardUrl = "/rest-password?reset=false";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);
		}


	}
}
