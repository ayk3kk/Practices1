package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chapter4/hello2")
public class Hello2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cnt = Integer.parseInt(request.getParameter("cnt"));

		//出力するデータ形式と、文字エンコーディングを設定します。
		response.setContentType("text/html; charset=UTF-8");

		//出力ストリームをインスタンス生成します。
		PrintWriter out = response.getWriter();

		for(int i = 0; i < cnt; i++) {
			out.println("<p>Hello</p>");
		}
		out.println("こんにちは！");
		out.println(new java.util.Date());

		System.out.println(request.getClass());
		System.out.println(response.getClass());
	}

}
