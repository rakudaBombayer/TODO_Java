<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoタスク詳細画面を表示(新規登録)</title>
</head>
<body>
<h1>ToDoタスク詳細画面を表示(新規登録)</h1>

<form action="TaskInsertServlet" method="post">
<table border="1">
  <tr>
    <th>タスクID</th>
    <th>(新規)</th>
  </tr>
  <tr>
    <td>タスク名称</td>
    <td><input type="text" name="task_name"></td>
  </tr>
  <tr>
    <td>タスク内容</td>
    <td><input type="text" name="task_contents"></td>
  </tr>
  <tr>
    <td>タスク期限</td>
    <td><input type="date" name="task_limitdate"></td>
  </tr>
  <tr>
    <td>タスク担当者</td>
    <td><input type="text" name="task_user"></td>
  </tr>
  <tr>
    <td>タスク状況</td>
    <td>
		
		<select name="task_status">
  		<c:forEach var="status" items="${taskStatusList}">
    	<option value="${status.status}">
      		<c:out value="${status.label}" />
    	</option>
  		</c:forEach>
		</select>
		
  	</td>
  </tr>
</table>
<input type="submit" value="登録">
</form>

<div><a href="TaskListServlet">タスク一覧へ</a></div>
</body>
</html>