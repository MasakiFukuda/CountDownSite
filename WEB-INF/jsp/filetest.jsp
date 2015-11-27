<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>fileのアップロード</title>
	</head>
	<body>
		<form action="upper" method="post" enctype="multipart/form-data">
			<input type="file" name="filename" size="30" accept="image/*">
			<input type="submit" value="アップロード">
		</form>
	</body>
</html>