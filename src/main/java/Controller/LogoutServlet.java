package Controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/menu.jsp");
//		dispatcher.forward(request, response);
		
}

protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		
		//リクエストパラメーターの実行
		request.setCharacterEncoding("UTF-8");
	

		
		System.out.println("ログアウトが成功しました。" );
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/login.jsp");
		dispatcher.forward(request, response);
	
		
	}

}