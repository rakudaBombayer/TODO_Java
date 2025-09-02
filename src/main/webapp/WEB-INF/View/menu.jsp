<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面を表示</title>
</head>
<body>
<h1>メニュー画面を表示</h1>
<div><a href="TaskListServlet">TODOタスク一覧</a></div>
<div><a href="TaskInsertServlet">TODOタスク登録</a></div>

<form action="LogoutServlet" method="post">

<input type="submit" value="ログアウト">
</form>
</body>
</html>