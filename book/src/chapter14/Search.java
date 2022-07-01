package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.Product;
import tool.SqlReader;

/**
 * お寿司の検索コントローラー
 */
@WebServlet("/chapter14/search")
public class Search extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 検索結果をテンプレートに転送するためのリストを準備します。
		List<Product> listResults = new ArrayList<>();

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			// コネクションプールから、接続済みConnectionを取得します。
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			// 検索フォームから送信されてきた「キーワード」を取得します。
			request.setCharacterEncoding("UTF-8");
			String keyword = request.getParameter("keyword");

			// SQL文を作成し、実行します。
			ServletContext application = request.getServletContext();
			String realPath = application.getRealPath("/sql/search/.sql");
			String sql = SqlReader.readSql(realPath);
//			String sql = "SELECT * FROM product WHERE name LIKE ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + keyword + "%");
			ResultSet rs = st.executeQuery();

			// 実行結果を利用し、必要な処理を実行します。
			while(rs.next()) {
				// 商品beanを生成し、リストの末尾に追加します。
				listResults.add(
						new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"))
				);
			}

			// リソースを解放し、コネクションをプールへ返却します。
			rs.close();
			st.close();
			con.close();

			// JSPテンプレートに転送するリストをリクエスト属性に格納します。
			request.setAttribute("keyword", keyword);
			request.setAttribute("listResults", listResults);

			// JSPテンプレートにフォワードします。
			request.getRequestDispatcher("search_result.jsp").forward(request, response);

		}catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}