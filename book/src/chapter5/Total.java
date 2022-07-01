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
 * 計算を行うサーブレット
 */
@WebServlet("/chapter5/total")
public class Total extends HttpServlet {

	/**
	 * 計算フォームの入力データを処理する、リクエストハンドラー
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			//計算フォームの入力データを取得します。
			int price = Integer.parseInt(request.getParameter("price"));
			int count = Integer.parseInt(request.getParameter("count"));

			Page.header(out);

			out.println("<h1>数値を取得して計算を行うサーブレット</h1>");

			//金額計算の「式」「結果」をレスポンスします。
			out.println(price + "円 ×");
			out.println(count + "個 ＝ ");
			out.println(price * count + "円");

			out.println("<p><a href='../chapter5/total.html'>計算フォーム</a>へ戻る</p>");

			Page.footer(out);

		}catch (Exception e) {
			//例外ハンドラー
			out.println("<p>数値を入力してください。</p>");
		}
	}

}
