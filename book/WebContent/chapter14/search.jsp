<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.html" %>

<h1>商品情報の検索</h1>

<p>検索ワードを入力してください。</p>

<form action="search" method="post">
	<input type="text" name="keyword">
	<input type="submit" value="検索">
</form>

<p><a href="../index.html">トップページへ戻る</a></p>

<%@ include file="../footer.html" %>