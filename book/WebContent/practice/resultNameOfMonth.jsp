<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// コントローラから受け渡されたオブジェクトを取り出します。
	int num = (int)request.getAttribute("num");
	String result = (String)request.getAttribute("result");
%>

<%@ include file="../header.html" %>

<h1>月の名前検索</h1>

<% if(result == null){ %>
	<p class="err-msg">月が選択されていません。</p>
<% } else{ %>
	<p><%= num %>月の名前は「<%= result %>」です。</p>
<% } %>

<p><a href="searchNameOfMonth.jsp">検索フォーム</a>へ戻る</p>

<%@ include file="../footer.html" %>