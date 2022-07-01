package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * tool#Pageをテストしてみるためのサーブレットクラス
 *
 */
@WebServlet("/chapter4/hello4")
public class Hello4 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//出力ストリームをインスタンス生成します。

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		Page.header(out);

		//このクラス固有の処理
		out.println("<h1>HTMLを出力する処理の整理</h1>");
		out.println("<p>Hello!</p>");
		out.println("<p>こんにちは！</p>");
		out.print("<p><a href='../index.html'>トップページへ戻る</a></p>");
		out.println("<p>" + new java.util.Date() +"</p>");

		Page.footer(out);
	}

}
