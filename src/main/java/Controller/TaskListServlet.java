package Controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Login;
import model.TaskCheck;
import model.TaskInfo;
import model.TodoTaskDAO;

//ToDoタスク一覧処理を行うサーブレット

@WebServlet("/TaskListServlet")
public class TaskListServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		
		TodoTaskDAO dao = new TodoTaskDAO();
		List<TaskInfo> taskList = dao.getAllTasks();
		
		
		
//		String userId = request.getParameter("user_id");
//		String userPass = request.getParameter("user_pass");
		
		// セッションからログイン情報を取得
	    HttpSession session = request.getSession();
	    Login userLogin = (Login) session.getAttribute("login");
	    
	    if (userLogin == null) {
		    response.sendRedirect("LoginServlet");
		    return;
		}
	    
	    
	    //お試し
	    for (TaskInfo task : taskList) {
	        int status = Integer.parseInt(task.getTaskStatus()); // ← 型変換
	        TaskCheck check = dao.getStatus(status);
	        if (check != null) {
	            task.setTaskLabel(check.getLabel()); // ← getterが必要
	            task.setTask_progress(check.getProgress());
	            System.out.println("task_progress: " + check.getProgress());
	        } else {
	            task.setTaskLabel("不明なステータス");
	        }
	    }
	    //お試し

		
		
		// JSPに渡す
		request.setAttribute("login", userLogin);
		request.setAttribute("taskList", taskList);
    
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/tasklist.jsp");
		dispatcher.forward(request, response);
		

	}
	
	protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
		doGet(request, response); // POSTでも同じ処理を使う
	}

}