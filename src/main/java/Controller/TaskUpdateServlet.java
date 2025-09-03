package Controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		
		
		//ここから始める。Updateの続きから（そもそもデータベースからidを取り出す必要があるのか？調べる）
//		TaskInfo task = TodoTaskDAO.findById(task_id); // DBから1件取得
//		request.setAttribute("task", task);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("taskUpdate.jsp");
//		dispatcher.forward(request, response);
//		

		
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
		

		
	}
}