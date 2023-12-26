<%@ page import="common.StringUtil"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="contact" scope="request" class="beans.ContactBeans" />
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<title>CONTACT</title>
	<link rel="stylesheet" href="css/styles.css">
	<!--[if lt IE 9]>
	<script src="/mt-static/support/theme_static/rainier/js/html5shiv.js"></script>
	<![endif]-->
</head>
<body>
<main class="page-main page-form page-contact">
	<header class="page-header-contact">
		<h1>CONTACT</h1>
	</header>

	<div class="container">
		<form class="form-container" action="contact" method="post">
			<%
				Map<String, String> errors = (HashMap<String, String>)request.getAttribute("errors");
			%>

			<div class="form-table">
				<section class="form-table-row form-table-name">
					<h2>ご氏名 <span class="required">必須</span></h2>
					<div class="form-table-col">
						<input class="input" type="text" name="name" placeholder="" value="<jsp:getProperty name="contact" property="name" />">
						<% if (errors.containsKey("name")) { %>
						<p><span style="color:#ff0000;"><%= errors.get("name") %></span></p>
						<% } %>
					</div>
				</section>

				<section class="form-table-row form-table-email">
					<h2>メールアドレス <span class="required">必須</span></h2>
					<div class="form-table-col">
						<input class="input" type="text" name="mail" placeholder="" value="<jsp:getProperty name="contact" property="mail" />">
						<% if (errors.containsKey("mail")) { %>
						<p><span style="color:#ff0000;"><%= errors.get("mail") %></span></p>
						<% } %>
					</div>
				</section>

				<section class="form-table-row form-table-company-name">
					<h2>タイトル <span class="required">必須</span></h2>
					<div class="form-table-col">
						<input class="input" type="text" name="title" placeholder="" value="<jsp:getProperty name="contact" property="title" />">
						<% if (errors.containsKey("title")) { %>
						<p><span style="color:#ff0000;"><%= errors.get("title") %></span></p>
						<% } %>
					</div>
				</section>

				<section class="form-table-row form-table-pr">
					<h2>お問い合わせ内容 <span class="required">必須</span></h2>
					<div class="form-table-col">
						<textarea class="textarea" placeholder="1,000文字以内でご記入ください" maxlength="1000" name="body"><jsp:getProperty name="contact" property="body" /></textarea>
						<% if (errors.containsKey("body")) { %>
						<span style="color:#ff0000;"><%= errors.get("body") %></span>
						<% } %>
					</div>
				</section>
			</div>

			<p />

			<div style="text-align: center;">
				<button type="submit" class="form-button" name="edit"><span>確認画面へ</span></button>
			</div>
		</form>
	</div>
</main>
</body>
</html>