<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面を表示</title>
</head>
<body>
<h1>ログイン画面を表示</h1>

<body>
<form action="LoginServlet" method="post">
ユーザーID:<input type="text" name="user_id"><br>
パスワード:<input type="text" name="user_pass"><br>
<input type="submit" value="ログイン">
</form>
</body>

</body>
</html>