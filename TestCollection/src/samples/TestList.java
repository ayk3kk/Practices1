package samples;

import java.util.ArrayList;
import java.util.List;


/**
 * Listを使う練習
 *
 * @author 21002S
 *
 */
public class TestList {

	public static void main(String[] args) {

		// 空のListをインスタンス生成します。
		List<String> listNames = new ArrayList<String>();

		// 末尾に要素を追加します。
		listNames.add("Java");
		listNames.add("C++");
//		listNames.add(new Date());  //←設計上、期待しない型が格納できてしまう
		listNames.add("JavaScript");
		listNames.add("PHP");

		// リストをシーケンシャルアクセスします。
		for(String s : listNames) {
			System.out.println(s + ": " + s.length() + "文字");
		}

//		for(int i = 0; i < listNames.size(); i++) {
//			System.out.println(listNames.get(i));
//		}

		//あらゆる型のオブジェクトが格納可能な配列（Object型）
//		Object[] names = new Object[5];
//
//		names[0] = "Java";
//		names[1] = "C++";
//		names[2] = new Date();  //←ここにDateオブジェクトを格納する
//		names[3] = "JavaScript";
//		names[4] = "HTML";
//
//		for(Object n : names) {
//			if(n instanceof String) {
//				System.out.println(n + ":" + ((String) n).length() + "文字");
//			}else {
//				System.out.println(n);
//			}
//		}
//
	}

}
