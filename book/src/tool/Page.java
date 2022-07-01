package tool;

import java.io.PrintWriter;

/**
 * HTMLの共通部分を出力するクラス
 *
 * @author 21002S
 *
 */
public class Page {

	public static void header(PrintWriter out) {

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet/JSP Sample Programs</title>");
		out.println("<link rel='stylesheet' href='../styles/styles.css'>");
		out.println("</head>");
		out.println("<body>");
	}

	public static void footer(PrintWriter out) {

		out.println("</body>");
		out.println("</html>");
	}
}
