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
 * 商品一覧のコントローラ
 */
@WebServlet("/chapter14/all")
public class All extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

//		Page.header(out);
//		out.println("<h1>お寿司の一覧</h1>");

		try {
			// 商品beanをひとまとめにするリストを準備します。
			List<Product> listProducts = new ArrayList<>();

			// データベースへ接続します。
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/book");
			// コネクションプールから接続済みConnectionを取得します。
			Connection con = ds.getConnection();

			// 外部SQLファイルを入力し、実行します。
			ServletContext application = request.getServletContext();
			// 外部SQLファイルの絶対パスを取得します。
			String realPath = application.getRealPath("/sql/all.sql");
			System.out.println(realPath);
			String sql = SqlReader.readSql(realPath);
//			String sql = "SELECT * FROM product;";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				// 商品情報1件分をひとまとめにbean化し、リスト末尾に追加します。
				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
				listProducts.add(p);
			}

			// 実行結果を利用し、必要な処理をおこないます。
//			while(rs.next()) {
//				out.println(rs.getInt("id"));
//				out.println("：");
//				out.println(rs.getString("name"));
//				out.println("：");
//				out.println(rs.getInt("price"));
//				out.println("<br>");
//			}

			// リソースを解放し、
			// コネクションプールにConnectionを返却します。
			rs.close();
			st.close();
			con.close();

			// リクエスト属性(Map)に商品リストを格納します。
			request.setAttribute("listProducts", listProducts);

			// JSPテンプレートへフォワードします。
			request.getRequestDispatcher("all_result.jsp").forward(request, response);

		}catch (Exception e) {
			e.printStackTrace(out);
		}

//		Page.footer(out);
	}

}
