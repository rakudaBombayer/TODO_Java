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
import model.TodoTaskDAO;

//ToDoタスクの新規登録処理を行うサーブレット

@WebServlet("/TaskInsertServlet")
public class TaskInsertServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		
	// task_status の選択肢を取得　お試し↓
		TodoTaskDAO TodoTaskDAO = new TodoTaskDAO();
		List<TaskCheck> statusList = TodoTaskDAO.getAvailableStatuses(); // 

		request.setAttribute("taskStatusList", statusList);
	//お試し↑
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/taskdetail.jsp");
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

		

		
		System.out.println("タスク送信: " + task_name + " / " + task_contents );
		System.out.println("タスク送信: " + task_limitdate + " / " + task_user + " / " + task_status);
		
		TodoTaskDAO dao = new TodoTaskDAO();
		boolean isInserted = dao.insertTask(task_name, task_contents, task_limitdate, task_user, task_status);
		
		if (isInserted) {
		    System.out.println("タスク登録成功");

			 response.sendRedirect("TaskListServlet");
		} else {
		    System.out.println("タスク登録失敗");
		    // エラーメッセージ表示など
		}
		

		
	}
}