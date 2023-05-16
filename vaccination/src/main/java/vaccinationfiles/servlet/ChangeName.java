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


@WebServlet("/ChangeName")
public class ChangeName extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("ChangeName.jsp");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String name  = request.getParameter( "newName");
    	int id =Integer.parseInt( request.getParameter( "id"));
    	UDBService db = new UDBService();
    	db.changeUsername(name, id);
    	
    	
    	User updatedUser = db.getUser(id);
        HttpSession session = request.getSession();
        session.setAttribute("user", updatedUser);
        
        
        if (request.getSession(false) != null && request.getSession(false).getAttribute("user") != null) {
        	response.sendRedirect("Profile.jsp");	
		} else {
			response.sendRedirect("index.jsp");
		}
        
        db.close();
    }
    
    
}
