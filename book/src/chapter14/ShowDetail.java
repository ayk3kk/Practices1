package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
 * 商品詳細ページのコントローラ
 */
@WebServlet({"/chapter14/show_detail", "/chapter15/show_detail"})
public class ShowDetail extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		try {
			// 商品一覧表から送信されてくる「商品ID」を取得します。
			int id = Integer.parseInt(request.getParameter("id"));

			// データベースへの接続済みConnectionを取得します。
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/book");
			Connection cn = ds.getConnection();

			// 詳細表示する商品情報を取得します。
			ServletContext application = request.getServletContext();
			// 外部SQLファイルの絶対パスを取得します。
			String realPath = application.getRealPath("/sql/show_detail.sql");
			String sql = SqlReader.readSql(realPath);

			// SQLを実行し、結果セットを取得します。
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, id);	// ← 商品一覧で選択された商品IDをセットする
			ResultSet rs = pst.executeQuery();

			// 商品情報をbean化します。
			Product p = null;
			if(rs.next()) {
				p = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
			}

			// リソースを解放し、Connectionをプールに返却します。
			rs.close();
			pst.close();
			cn.close();

			// 商品beanをリクエスト属性に格納し、JSPテンプレートへフォワードします。
			request.setAttribute("product", p);
			request.getRequestDispatcher("show_detail.jsp").forward(request, response);

		}catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}
