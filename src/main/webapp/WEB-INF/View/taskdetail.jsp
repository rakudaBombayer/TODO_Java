<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoタスク詳細画面を表示(新規登録・変更・削除)</title>
</head>
<body>
<h1>ToDoタスク詳細画面を表示(新規登録・変更・削除)</h1>
<div>(新規登録・変更・削除)</div>
<div>タスク表</div>
<div>タスクID</div>
<div>タスク内容</div>

<form action="TaskInsertServlet" method="post">
<input type="submit" value="登録">
</form>
<form action="TaskUpdateServlet" method="post">
<input type="submit" value="変更">
</form>
<form action="TaskDeleteServlet" method="post">
<input type="submit" value="削除">
</form>
<div><a href="TaskListServlet">タスク一覧へ</a></div>
</body>
</html>