package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TaskCheck;
import model.TaskInfo;
import model.TodoTaskDAO;

//ToDoタスクの変更処理を行うサーブレット

@WebServlet("/TaskUpdateServlet")
public class TaskUpdateServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		
		//tasklist.jspからtaskupdate.jspにtaskidのデータを渡すための処理(仮)
		String taskIdStr = request.getParameter("taskId");
		if (taskIdStr != null && !taskIdStr.isEmpty()) {
			int taskId = Integer.parseInt(taskIdStr);

			TodoTaskDAO dao = new TodoTaskDAO();
			TaskInfo task = dao.findById(taskId); // ← DBから1件取得

			request.setAttribute("task", task); // JSPに渡す
		}
		//tasklist.jspからtaskupdate.jspにtaskidのデータを渡すための処理(仮)
		
		
		// task_status の選択肢を取得　お試し↓
		TodoTaskDAO TodoTaskDAO = new TodoTaskDAO();
		List<TaskCheck> statusList = TodoTaskDAO.getAvailableStatuses(); 

		request.setAttribute("taskStatusList", statusList);
		//お試し↑
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/taskupdate.jsp");
		dispatcher.forward(request, response);
		
	}
protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	
		//リクエストパラメーターの実行
		request.setCharacterEncoding("UTF-8");
		

		String task_name = request.getParameter("task_name");
		String task_contents = request.getParameter("task_contents");
		
		String task_limitdate = request.getParameter("task_limitdate");
		String task_user = request.getParameter("task_user");
		
		String task_status_str = request.getParameter("task_status");
		int task_status = Integer.parseInt(task_status_str); 
		
		String taskIdStr = request.getParameter("taskId");
		int task_id = Integer.parseInt(taskIdStr);
		
		

		
		System.out.println("タスク変更送信: " + task_name + " / " + task_contents );
		System.out.println("タスク変更送信: " + task_limitdate + " / " + task_user + " / " + task_status+ " / " + task_id);
		
		TodoTaskDAO dao = new TodoTaskDAO();
		boolean isUpdated = dao.getUpdate(task_name, task_contents, task_limitdate, task_user, task_status, task_id);
		
		if (isUpdated) {
		    System.out.println("タスク変更成功");

			 response.sendRedirect("TaskListServlet");
		} else {
		    System.out.println("タスク登録失敗");
		    // エラーメッセージ表示など
		}
		
		//お試し
		List<String> errors = new ArrayList<>();

		if (task_name == null || task_name.trim().isEmpty()) {
		    errors.add("タスク名称が空白です");
		} else if (task_name.length() > 50) {
		    errors.add("タスク名称が長すぎます");
		}

		if (task_contents == null || task_contents.trim().isEmpty()) {
		    errors.add("タスク内容が空白です");
		} else if (task_contents.length() > 100) {
		    errors.add("タスク内容が長すぎます");
		}

		if (task_limitdate == null || task_limitdate.trim().isEmpty()) {
		    errors.add("タスク期限が空白です");
		} else {
		    try {
		        LocalDate limitDate = LocalDate.parse(task_limitdate);
		        if (task_status == 2 && limitDate.isBefore(LocalDate.now())) { // 進行中なら過去日付NG
		            errors.add("タスク期限が過去日付です");
		        }
		    } catch (DateTimeParseException e) {
		        errors.add("タスク期限の入力形式が違います");
		    }
		}

		if (task_user == null || task_user.trim().isEmpty()) {
		    errors.add("タスク担当者が空白です");
		} else if (task_user.length() > 20) {
		    errors.add("タスク担当者が長すぎます");
		}

		
	}
}