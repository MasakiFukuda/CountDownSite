<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>mailの送信テスト</title>
	</head>
	<body>
		<form action="mailserv" method="post">
			相手のアドレス:<input type="text" name="toadd"><br>
			タイトル:<input type="text" name="title"><br>
			本文: <textarea name="mess" rows="4" cols="40"></textarea><br>
			<input type="submit" value="送信">
		</form>
	</body>
</html>