<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Product" %>
<%@ page import="java.util.List" %>

<%
   // コントローラから転送されたリストを取得します。
   String keyword = (String)request.getAttribute("keyword");
	List<Product> listResults = (List<Product>)request.getAttribute("listResults");
%>

<%@ include file="../header.html" %>

<h1>お寿司の検索結果</h1>

<h2>検索キーワード「<%= keyword %>」</h2>

<% if(listResults.size() == 0){ %>
	<p class="err-msg">検索キーワードにマッチする商品は登録されていません。</p>
<%  } %>


<table>
<tr><th>商品ID</th><th>商品名</th><th>単価</th></tr>
<%
	int i = 1;
	for(Product p : listResults){
%>
<tr class='<%= i % 2 == 1 ? "odd" : "even" %>'>
	<td><%= p.getId() %></td>
	<td><%= p.getName() %></td>
	<td>\<%= p.getPrice() %></td>
</tr>
<%
		i++;
	}
%>
</table>

<p>
<a href="search.jsp">検索フォームへ戻る</a>
</p>
<%@ include file="../footer.html" %>