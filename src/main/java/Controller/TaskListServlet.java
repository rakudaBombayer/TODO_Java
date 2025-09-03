package Controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

		// JSPに渡す
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