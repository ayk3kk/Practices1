<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Product" %>
<%@ include file="../header.html" %>

<%
	//コントローラから転送されてきたオブジェクトを取得します。
	Product p = (Product)request.getAttribute("added_product");
	int line = (int)request.getAttribute("line");
%>

<h1>お寿司の追加結果</h1>

<p><a href="../index.html">トップページへ戻る</a>　<a href="insert.jsp">追加フォームへ戻る</a></p>

<% if(line > 0){ %>
	<p>以下の商品情報を追加しました。</p>
	<ul>
		<li>商品名：<%= p.getName() %></li>
		<li>価　格：<%= p.getPrice() %></li>
	</ul>
<% } %>

<%@ include file="../footer.html"%>