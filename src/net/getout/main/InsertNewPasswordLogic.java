package net.getout.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.getout.dao.UpdatePasswordDAO;

//パスワードをアップデートする　newパスワード入力フォームより遷移
@WebServlet("/InsertNewPasswordLogic")
public class InsertNewPasswordLogic extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストからパス　セッションからメールをゲット
		String newPassword = request.getParameter("password");
		HttpSession session = request.getSession();
		String mail = (String) session.getAttribute("mail");

		//パスワードをアップデートする
		UpdatePasswordDAO updatePasswordDAO = new UpdatePasswordDAO();
		updatePasswordDAO.updatePassword(newPassword, mail);

		//パラメータ入れてログイン画面に飛ばす
		String forwardUrl = "/login?update=success2";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);

	}

}
