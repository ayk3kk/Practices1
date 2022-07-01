package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * フォームから送信されたリクエストパラメータを取得します。
 */
@WebServlet("/chapter5/greeting")
public class Greeting extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 出力ストリームをインスタンス生成します。
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		//フォームから送信された「言語」「お名前」「得意なプログラミング言語」を取得します。
		request.setCharacterEncoding("UTF-8"); 		//日本語文字化けを防ぐ
		String lang = request.getParameter("lang");
		String user = request.getParameter("user");
		String[] pgmLangs = request.getParameterValues("pgm-lang");

		// HTMLドキュメントを出力します。
		Page.header(out);

		if(lang.equals("jpn")) {
			out.println("<h1>リクエストパラメータを取得するサーブレット</h1>");
			out.println("<p>こんにちは、" + user + "さん！</p>");

		}else {
			out.println("<h1>Servlet to get rewuest parameters</h1>");
			out.println("<p>Hello、" + user + ".!!</p>");
		}

		out.println("<p>得意なプログラミング言語は、以下の通りですね？</p>");

		if(pgmLangs == null) {
			out.println("<p class='err-msg'>得意なプログラミング言語が選択されていません。</p>");
		}else {
			out.println("<ol>");
			for(String pl : pgmLangs) {
				out.println("<li class='pgm-lang'>  " + pl + "  </li>");
			}
			out.println("</ol>");
		}

		out.println("<p><a href='greeting.html'> 入力フォーム</a>に戻る</p>");

		Page.footer(out);
	}

}
