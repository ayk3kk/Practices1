<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<%@ include file="../header.html" %>

<h1>HTML共通部分を取り込むテスト</h1>

<%
	String[] names = {"January", "February", "March" ,"April", "May", "June",
			"July", "August", "September","October", "November", "December"};
%>

<%-- 月の名前を選択できるプルダウンリストを出力します。 --%>
<%-- 入力値には、選択された「月の名前」に対する「数字1～12」を設定します。 --%>
<form>
<select>
<% for(int i = 0; i<names.length; i++){ %>
	<option value="<%= i + 1 %>"><%= names[i] %></option>
<% } %>
</select>
</form>



<p>Hello！</p>
<p>こんにちは！</p>

<p>
	<% out.println(new Date()); %>
</p>

<p>
	<%= new Date()%>
</p>

<p><a href="../index.html">トップページへ戻る</a></p>

<%@ include file="../footer.html" %>