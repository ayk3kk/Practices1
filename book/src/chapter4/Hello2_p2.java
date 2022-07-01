package chapter4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello2_p2
 */
@WebServlet("/Hello2_p2")
public class Hello2_p2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int cnt = Integer.parseInt(request.getParameter("cnt"));

	response.setContentType("text/html; charset=utf-8");

	PrintWriter out = response.getWriter();

		for(int i = 0; i < cnt; i++) {
			out.println("<p>Hello!</p>");
			out.println(new Date());
		}

		System.out.println(request.getClass());
		System.out.println(response.getClass());
	}


}
