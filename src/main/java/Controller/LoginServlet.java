package Controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Login;
import model.TodoTaskDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/login.jsp");
		dispatcher.forward(request, response);
		
}

protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		
		//リクエストパラメーターの実行
		request.setCharacterEncoding("UTF-8");
	
		String user_id = request.getParameter("user_id");
		String user_pass = request.getParameter("user_pass");
		
		System.out.println("フォーム入力: " + user_id + " / " + user_pass);
		
		TodoTaskDAO dao = new TodoTaskDAO();
		boolean isLogin = dao.isLoginValid(user_id, user_pass);
		
		if (isLogin) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/menu.jsp");
//			
//			dispatcher.forward(request, response);
			
			Login loginUser = new Login(user_id, user_pass);
			HttpSession session = request.getSession();
			session.setAttribute("login", loginUser);

			// メニュー画面へ遷移
			response.sendRedirect("MenuServlet");

			
			System.out.println("ログイン成功: " + user_id + " / " + user_pass);
		} else {
			
			request.setAttribute("errorMsg", "ユーザーIDまたはパスワードが違います");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/login.jsp");
	        dispatcher.forward(request, response);
	        
	        System.out.println("ログイン失敗: " + user_id + " / " + user_pass);
		}
		
	}

}