package Controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//ToDoタスクの新規登録処理を行うサーブレット

@WebServlet("/TaskInsertServlet")
public class TaskInsertServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/taskdetail.jsp");
		dispatcher.forward(request, response);
		
	}
}