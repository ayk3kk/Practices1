<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Product" %>

<%
	// コントローラから転送された商品beanを取得します。
	Product p = (Product)request.getAttribute("product");
%>


<%@ include file="../header.html" %>

<h1>お寿司の詳細情報</h1>

<p><a href="all">商品一覧</a>へ戻る</p>

<ul>
	<li>商品ID：<%= p.getId() %></li>
	<li>商品名：<%= p.getName() %></li>
	<li>単　価：<%= p.getPrice()+ "円" %></li>
</ul>

<img alt="<%= p.getName() %>の画像" src="https://bucket-it-user-kakemura.s3.ap-northeast-1.amazonaws.com/images/<%= p.getId() %>.jpg">

<%@ include file="../footer.html" %>