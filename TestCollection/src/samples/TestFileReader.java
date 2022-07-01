package samples;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * テキストファイルの入力練習
 *
 * @author 21002S
 *
 */
public class TestFileReader {

	public static void main(String[] args) {

		try {
			// 入力ファイルをオープンします。「/」→\\も可能
			BufferedReader in = new BufferedReader(new FileReader("C:/it_engineer24/test.txt"));

			String data = null;
			while((data = in.readLine()) != null) {
				System.out.println(data);
			}


//			while(true) {
//				// 1行分のテキストを入力し、コンソールに表示します。
//				String data = in.readLine();
//				if(data == null) {
//					break;
//				}
//				System.out.println(data);
//			}

			// ファイルをクローズします。
			in.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
