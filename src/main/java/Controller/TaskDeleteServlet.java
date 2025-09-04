package Controller;

import java.io.IOException;
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

@WebServlet("/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		
	
			//tasklist.jspからtaskdelete.jspにtaskidのデータを渡すための処理(仮)
			String taskIdStr = request.getParameter("taskId");
			if (taskIdStr != null && !taskIdStr.isEmpty()) {
				int taskId = Integer.parseInt(taskIdStr);

				TodoTaskDAO dao = new TodoTaskDAO();
				TaskInfo task = dao.findById(taskId); // ← DBから1件取得

				request.setAttribute("task", task); // JSPに渡す
			}
			//tasklist.jspからtaskdelete.jspにtaskidのデータを渡すための処理(仮)
			
			// task_status の選択肢を取得　お試し↓
			TodoTaskDAO TodoTaskDAO = new TodoTaskDAO();
			List<TaskCheck> statusList = TodoTaskDAO.getAvailableStatuses(); // 

			request.setAttribute("taskStatusList", statusList);
			//お試し↑
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/taskdelete.jsp");
		dispatcher.forward(request, response);
		
	}
protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		
		//リクエストパラメーターの実行
		request.setCharacterEncoding("UTF-8");
		
		
		String taskIdStr = request.getParameter("taskId");
		
		//いらんとおもう後で消す。↓
//		if (taskIdStr == null || taskIdStr.isEmpty()) {
//		    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "taskIdが指定されていません");
//		    return;
//		}
		
		int task_id = Integer.parseInt(taskIdStr);
		
		System.out.println("タスク削除: " + task_id);
		
		TodoTaskDAO dao = new TodoTaskDAO();
		boolean isgetDeleted = dao.getDelete(task_id);
		
		if (isgetDeleted) {
		    System.out.println("削除成功");

			 response.sendRedirect("TaskListServlet");
		} else {
		    System.out.println("削除失敗");
		    // エラーメッセージ表示など
		}
		

		
	}
}