package tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 外部SQLファイルを読み込み、アプリケーションに提供するクラス
 *
 * @author 21002S
 *
 */
public class SqlReader {

	public static String readSql(String path) throws IOException {

		StringBuilder result = new StringBuilder();

		//外部SQLファイルをオープンします。
		BufferedReader in = new BufferedReader(new FileReader(path));

		// SQL文を1行ずつ読み込みながら、StringBillder末尾に追加します。
		String line = null;
		while((line = in.readLine()) != null){
			result.append(line + "\n");
		}

		in.close();

		return result.toString();
	}
}
