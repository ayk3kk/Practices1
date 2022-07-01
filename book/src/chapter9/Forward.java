package chapter9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * フォワード元のサーブレットクラス
 */
@WebServlet("/chapter9/forward")
public class Forward extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 整数列の合計を求めます。
		int total = 0;
		for(int i = 1; i <= 100; i++) {
			total += i;
		}

		// 求められた合計値を、「リクエスト属性(Map)」に保管します。
		request.setAttribute("total", total);

		//JSPテンプレートへフォワードします。
		request.getRequestDispatcher("forward.jsp").forward(request, response);


//		RequestDispatcher rd = request.getRequestDispatcher("forward.jsp");
//		System.out.println(rd.getClass());
//		rd.forward(request, response);

//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//
//		out.println("<h1>フォワード元サーブレット</h1>");

	}
}
