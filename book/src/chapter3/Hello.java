package chapter3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/chapter3/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// HTMLの出力ストリームオブジェクトをインスタンス生成します。
		PrintWriter out = response.getWriter();
		System.out.println(out.getClass());

		for(int i = 0; i < 10; i++) {
			out.println("<p>Hello!</p>");
		}

		// Dateオブジェクトの文字列表現が出力されます。
		out.println(new Date());

	}

}
