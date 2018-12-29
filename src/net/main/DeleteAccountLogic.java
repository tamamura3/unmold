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
import net.unmold.dao.DeleteAccountDAO;

@WebServlet("/DeleteAccountLogic")
public class DeleteAccountLogic extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inLogic");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedIn");
		System.out.println(user.getId());

		int userId = user.getId();
		DeleteAccountDAO deleteAccountDAO = new DeleteAccountDAO();
		deleteAccountDAO.deleteAccount(userId);
		System.out.println(userId);

		String forwardUrl = "/account-deleted";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);

	}
}
