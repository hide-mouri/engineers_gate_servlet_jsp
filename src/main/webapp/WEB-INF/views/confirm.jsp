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
		<form class="form-container" action="send" method="post">
			<div class="form-note">
				<p>入力内容をご確認ください。<br>
			</div>
			<div class="form-table">
				<section class="form-table-row form-table-name">
					<h2>ご氏名 <span class="required">必須</span></h2>
					<div class="form-table-col">
						<p><jsp:getProperty name="contact" property="name" /></p>
					</div>
				</section>

				<section class="form-table-row form-table-email">
					<h2>メールアドレス <span class="required">必須</span></h2>
					<div class="form-table-col">
						<p><jsp:getProperty name="contact" property="mail" /></p>
					</div>
				</section>

				<section class="form-table-row form-table-company-name">
					<h2>タイトル <span class="required">必須</span></h2>
					<div class="form-table-col">
						<p><jsp:getProperty name="contact" property="title" /></p>
					</div>
				</section>

				<section class="form-table-row">
					<h2>お問い合わせ内容 <span class="required">必須</span></h2>
					<div class="form-table-col">
						<p><jsp:getProperty name="contact" property="body" /></p>
					</div>
				</section>
			</div>

			<p />

			<div class="form-note">
				<p>上記内容でお間違いないようでしたら送信ボタンを押してください。</p>
			</div>
			<div style="text-align: center;">
				<button type="button" class="form-button" onclick="location.href='contact'"><span>戻る</span></button>
				<button type="submit" class="form-button"><span>送信</span></button>
			</div>
		</form>
	</div>
</main>
</body>
</html>