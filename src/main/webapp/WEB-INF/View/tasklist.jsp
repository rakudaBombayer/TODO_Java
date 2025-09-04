<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoタスク一覧画面を表示</title>
</head>
<body>
<h1>ToDoタスク一覧画面を表示</h1>
<table border="1">
	<thead>
		<tr>
			<th>タスクID</th>
			<th>タスク名称</th>
			<th>タスク内容</th>
			<th>タスク期限</th>
			<th>最終更新日</th>
			<th>タスク担当</th>
			<th>タスク状況</th>
			<th>詳細画面</th>
		</tr>
	</thead>

	<tbody>
    <c:forEach var="task" items="${taskList}">
        <tr>
            <td><c:out value="${task.taskId}"/></td>
            <td><c:out value="${task.taskName}"/></td>
            <td><c:out value="${task.taskContents}"/></td>
            <td><c:out value="${task.taskLimitdate}"/></td>
            <td><c:out value="${task.taskUpdate}"/></td>
            <td><c:out value="${task.taskUser}"/></td>
            <td><c:out value="${task.taskLabel}"/></td>
            
            <td>
            <c:if test="${task.taskDelete != null}">
  				<span style="color:gray;">削除済み</span>
			</c:if>

			<c:if test="${task.taskDelete == null}">
  			<c:if test="${not task.task_progress}">
    			<a href="TaskUpdateServlet?taskId=${task.taskId}">変更へ</a>
    			
  				</c:if>
  			<c:if test="${task.task_progress}">
    				<a href="TaskDeleteServlet?taskId=${task.taskId}">変更・削除へ</a>
    				
  			</c:if>
			</c:if>
        	</td>         
        </tr>
        
    </c:forEach>
 
	</tbody>
	
</table>




<div style="margin: 16px 0;"><a href="TaskInsertServlet">新規登録へ</a></div>
<div style="margin-bottom: 16px;"><a href="MenuServlet">メニューへ</a></div>
<hr>
<div style="text-align: right;">
	<div>ログインユーザー名:<c:out value="${login.userId}"/></div>
</div>


</body>
</html>