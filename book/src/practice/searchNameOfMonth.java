package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 月の名前検索コントローラー
 */
@WebServlet("/practice/searchNameOfMonth")
public class searchNameOfMonth extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String[] NamesENG = {"未使用","January","February","March","April","May","June","July","August","September","October","November","December"};
		final String[] NamesJPN = {"未使用","睦月","如月","弥生","卯月","皐月","水無月","文月","葉月","長月","神無月","霜月","師走"};

		// フォームの入力値を取得します。
		int num = Integer.parseInt(request.getParameter("numberOfMonth"));
		String lang = request.getParameter("lang");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 配列を検索し、月の名前を取得します。
		String result = null;
		if(num != -1) {
			if(lang.equals("eng")) {
				result = NamesENG[num];
			}else {
				result = NamesJPN[num];
			}
		}

		//リクエスト属性に、JSPに受け渡すオブジェクトを格納します。
		request.setAttribute("num", num);
		request.setAttribute("result", result);

		// JSPテンプレートへフォワードします。
		request.getRequestDispatcher("resultNameOfMonth.jsp").forward(request, response);

//		Page.header(out);
//
//		if(result == null) {
//			out.println("<p class='err-msg'>月が選択されていません。</p>");
//		}else {
//			out.println("<p>"+ num + "月の名前は" + "「 " + result + "」です。</p>");
//		}
//		out.println("<p><a href='searchNameOfMonth.jsp'>検索フォーム</a>へ戻る</p>");
//
//		Page.footer(out);
	}

}
