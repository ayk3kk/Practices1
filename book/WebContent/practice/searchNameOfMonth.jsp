<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.html" %>

<p id="title">月の名前検索</p>

<form action ="searchNameOfMonth" method="post">

<p>月の名前を検索します。</p>

<p>
	<label>月を選択してください。</label>
	<select name="numberOfMonth">
		<option value="-1">-- 月を選択してください --</option>
		<% for(int i = 1; i <= 12; i++){ %>
				<option value="<%= i %>"><%= i %>月</option>
		 <% }%>
	</select>
</p>

<p>
	<input id="eng" type="radio" name="lang" value="eng" checked="checked">
	<label for="eng">英語</label>
	<input id="jpn" type="radio" name="lang" value="jpn">
	<label for="jpn">日本語</label>
</p>

<p><input type="submit" value="検索"></p>

</form>

<%@ include file="../footer.html" %>