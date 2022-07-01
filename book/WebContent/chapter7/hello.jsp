<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP Samples</title>
<link rel="stylesheet" href="../styles/styles.css">
</head>
<body>

<h1>はじめてのJSP</h1>

<%
	//プルダウンリストから送信された「繰り返し回数」を取得します。
	int count = Integer.parseInt(request.getParameter("count"));
%>

<!-- HTML形式のコメント -->
<%-- メッセージの入力 --%>
<p>JSPによる出力結果</p>
<% for(int i = 0; i < count; i++){ %>
	<p>Hello!</p>
<% } %>

<p>JavaScriptによる出力結果</p>
<script type="text/javascript">
for(var i = 0; i < 3; i++){
	document.write("<p>Hello!</p>");
}
</script>

<p>こんにちは!</p>

<p><a href="../index.html">トップページへ戻る</a></p>

</body>
</html>