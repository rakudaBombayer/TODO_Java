<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoタスク詳細画面を表示(変更・削除)</title>
</head>
<body>
<h1>ToDoタスク詳細画面を表示(変更・削除)</h1>
<div>変更・削除</div>


<form action="TaskUpdateServlet" method="post">
<table border="1">
  <tr>
    <th>タスクID</th>
    <th>(変更・削除)</th>
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
  			<option value="0">未着手</option>
  			<option value="1">着手</option>
  			<option value="2">凍結</option>
  			<option value="3">中断</option>
  			<option value="9">完了</option>
		</select>
  	</td>
  </tr>
</table>
<input type="hidden" name="taskId" value="${task.taskId}">
<input type="submit" value="変更">
</form>

<form action="TaskDeleteServlet" method="post" onsubmit="return confirmDelete()">
<input type="hidden" name="taskId" value="${task.taskId}">
<input type="submit" value="削除">
</form>

<p>taskId: ${task.taskId}</p>
<div><a href="TaskListServlet">タスク一覧へ</a></div>
</body>
</html>



<script>
  function confirmDelete() {
    return confirm("本当にこのタスクを削除しますか？");
  }
</script>