package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import bean.Product;
import tool.SqlReader;

/**
 * 商品テーブルに対するデータ処理（CRUD処理）をおこなうDAO
 *
 * @author 21002S
 *
 */
public class ProductDAO extends DAO {

	//すべての商品情報をコントローラへ提供します。
	public List<Product> all(ServletContext application) throws Exception {

		// すべての商品beanを格納するリストを準備しておきます。
		List<Product> listProducts = new ArrayList<>();

		//データベースへの接続を取得します。
		Connection cn = this.getConnection();

		//外部SQLファイルを読み込みます。
		String realPath = application.getRealPath("/sql/all.sql");
		String sql = SqlReader.readSql(realPath);
		PreparedStatement pst = cn.prepareStatement(sql);

		// SQLを実行し、結果セットを取得します。
		ResultSet rs = pst.executeQuery();

		//結果セットをシーケンシャルアクセスしながら、商品beanを生成し、リストに追加します。
		while(rs.next()) {
			Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
			listProducts.add(p);
		}

		// リソースを解放し、コネクションを返却します。
		rs.close();
		pst.close();
		cn.close();

		// サーブレットコントローラに、商品リストを提供します。
		return listProducts;
	}
}
