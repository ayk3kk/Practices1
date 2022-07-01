package samples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 外部SQLファイルの入力練習
 *
 */
public class TestSqlReader {

	public static void main(String[] args) {

		try {
			// 外部SQLファイルをオープンします。
			String path = "C:/it_engineer24/test.sql";
			BufferedReader reader = new BufferedReader(new FileReader(path));

			// SQLファイルを読み込み、結果を表示します。
			String sql = readSql(reader);
			System.out.println(sql);

			//ファイルをクローズします。
			reader.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}// main()

	// 外部ファイルからSQL文を読み込み、main()へ返します。
	private static String readSql(BufferedReader reader) throws IOException {

		StringBuilder sb = new StringBuilder();
//		String sql = "";

		String line = null;
		while((line = reader.readLine()) != null) {
			// 1行ずつ読み込み、結果末尾に追加します。
			sb.append(line + "\n");
//			sql += (line + "\n");
		}

		return sb.toString();
	}

}
