<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<p>佐藤友道</p>
					</div>
				</section>

				<section class="form-table-row form-table-email">
					<h2>メールアドレス <span class="required">必須</span></h2>
					<div class="form-table-col">
						<p>tsato@dcworks.jp</p>
					</div>
				</section>

				<section class="form-table-row form-table-company-name">
					<h2>タイトル <span class="required">必須</span></h2>
					<div class="form-table-col">
						<p>採用に関するお問い合わせ</p>
					</div>
				</section>

				<section class="form-table-row">
					<h2>お問い合わせ内容 <span class="required">必須</span></h2>
					<div class="form-table-col">
						<p>
							採用ご担当者様<br>
							<br>
							お世話になります。<br>
							私は佐藤と申します。貴社の魅力的な事業や企業文化に興味を持ち、採用に関する情報を知りしたく、お問い合わせいたしました。<br>
							<br>
							私は○○業界で5年間の経験を持ち、△△の専門知識とスキルを持っています。<br>
							貴社のビジョンや価値観に共感し、成長意欲を持って貴社でのキャリアを築きたいと考えております。<br>
							<br>
							以下の点について、採用に関する情報をお教えいただければ幸いです。<br>
							<br>
							１．採用職種や募集ポジションについて<br>
							２．応募に際して求められるスキルや経験<br>
							３．採用プロセスや選考のスケジュール<br>
							４．給与・福利厚生について<br>
							５．その他、採用に関連する情報や条件<br>
							<br>
							また、貴社のウェブサイト上で提供されている採用情報や募集要項を確認しましたが、もし追加情報や詳細をご提供いただける場合は、お知らせいただければ幸いです。
							<br>
							ご多忙のところ恐縮ですが、ご回答いただけると大変ありがたく存じます。<br>
							<br>
							何卒よろしくお願い申し上げます。<br>
							<br>
							敬具
						</p>
					</div>
				</section>
			</div>

			<p />

			<div class="form-note">
				<p>上記内容でお間違いないようでしたら送信ボタンを押してください。</p>
			</div>
			<div style="text-align: center;">
				<button type="button" class="form-button" onclick="location.href='contact'"><span>戻る</span></button>
				<button type="button" class="form-button" onclick="location.href='send'"><span>送信</span></button>
			</div>
		</form>
	</div>
</main>
</body>
</html>