<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.html" %>

<h1>お寿司の追加</h1>

<p>追加する商品を入力してください。</p>

<form action="insert" method="post">
	<label for="name">商品名</label>
	<input id="name" type="text" name="name">
	<label for="price">価格</label>
	<input id="price" type="text" name="price">
	<input type="submit" value="追加">
</form>

<p><a href="../index.html">トップページへ戻る</a>

<%@ include file="../footer.html" %>