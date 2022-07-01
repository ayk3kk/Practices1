<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.html" %>

<%
	// フォワード元から受け渡されたデータを「リクエスト属性」から取り出します。
	int total = (int)request.getAttribute("total");
%>

<h1>いろいろな画面遷移</h1>

<p>フォワード先のJSPファイルです。</p>

<p>整数列の和：<%= total %></p>

<%@ include file="../footer.html" %>