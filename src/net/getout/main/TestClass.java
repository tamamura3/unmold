package net.getout.main;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestClass")
public class TestClass extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		System.out.println("in test class");


			}

}
