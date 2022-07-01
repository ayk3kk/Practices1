package chapter9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * リダイレクト元のサーブレットクラス
 * →ブラウザを別のURLへ誘導します。
 */
@WebServlet("/chapter9/redirect")
public class Redirect extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ブラウザに対してリダイレクト先URLをレスポンスします。
		response.sendRedirect("http://tomcat.apache.org/");

	}

}
