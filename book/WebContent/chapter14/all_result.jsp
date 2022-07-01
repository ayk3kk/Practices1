<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Product" %>
<%@ page import="java.util.List" %>

<%
   // コントローラから転送されたリストを取得します。
	List<Product> listProducts = (List<Product>)request.getAttribute("listProducts");
%>

<%@ include file="../header.html" %>

<h1>お寿司の一覧</h1>

<table>
<tr><th>商品ID</th><th>商品名</th><th>単価</th></tr>
<%
	int i = 1;
	for(Product p : listProducts){
%>
<tr class='<%= i % 2 == 1 ? "odd" : "even" %>'>
	<td><a href="show_detail?id=<%= p.getId() %>"><%= p.getId() %></a></td>
	<td><a href="show_detail?id=<%= p.getId() %>"><%= p.getName() %></a></td>
	<td>\<%= p.getPrice() %></td>
</tr>
<%
		i++;
	}
%>
</table>

<p>
<a href="../index.html">トップページへ戻る</a>
</p>
<%@ include file="../footer.html" %>