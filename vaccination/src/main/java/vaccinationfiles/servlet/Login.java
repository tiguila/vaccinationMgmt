package vaccinationfiles.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vaccinationfiles.model.User;
import vaccinationfiles.service.UDBService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UDBService db = new UDBService();
		User user = db.getUser(username, password);
		
		if (user == null || user.getUsername() == null || !user.getUsername().equals(username) || !user.getPassword().equals(password)) {
		    response.sendRedirect("index.jsp");
		} else {
			HttpSession session = request.getSession();
            session.setAttribute("user", user);
		    response.sendRedirect("FrontPage.jsp");
		}
		
	}

}
