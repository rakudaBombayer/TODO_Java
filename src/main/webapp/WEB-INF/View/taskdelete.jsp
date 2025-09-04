<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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
    <th>${task.taskId}</th>
  </tr>
  <tr>
    <td>タスク名称</td>
    <td><input type="text" name="task_name" value="${task.taskName}"></td>
  </tr>
  <tr>
    <td>タスク内容</td>
    <td><input type="text" name="task_contents" value="${task.taskContents}"></td>
  </tr>
  <tr>
    <td>タスク期限</td>
    <td><input type="date" name="task_limitdate" value="${task.taskLimitdate}"></td>
  </tr>
  <tr>
    <td>タスク担当者</td>
    <td><input type="text" name="task_user" value="${task.taskUser}"></td>
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
<input type="hidden" name="taskId" value="${task.taskId}">
<input type="submit" value="変更">
</form>

<form action="TaskDeleteServlet" method="post" onsubmit="return confirmDelete()">
<input type="hidden" name="taskId" value="${task.taskId}">
<input type="submit" value="削除">
</form>


<div><a href="TaskListServlet">タスク一覧へ</a></div>
</body>
</html>

<c:if test="${not empty errors}">
<hr>
  <div style="color:red;">
    <ul>
      <c:forEach var="error" items="${errors}">
        <li>${error}</li>
      </c:forEach>
    </ul>
  </div>
</c:if>


<script>
  function confirmDelete() {
    return confirm("本当にこのタスクを削除しますか？");
  }
</script>