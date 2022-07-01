package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.Product;


/**
 * 商品追加処理のコントローラ
 */
@WebServlet("/chapter14/insert")
public class Insert extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		try {
			// データベースへのConnectionを取得します。
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			// 追加フォームから送信されてきた情報を取得します。
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));

			// SQL文を作成し、実行します。
			String sql = "INSERT INTO product VALUES(null, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setInt(2, price);
			int line = st.executeUpdate();

			//リソースを解放し、Connectionをプールに返却します。
			st.close();
			con.close();

			// JSPテンプレートへ転送するオブジェクトをリクエスト属性に格納します。
			Product p = new Product(0, name, price);
			request.setAttribute("added_product", p);
			request.setAttribute("line", line);

			// JSPテンプレートへフォワードします。
			request.getRequestDispatcher("insert_result.jsp").forward(request, response);

		}catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}
