package vaccinationfiles.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vaccinationfiles.service.PDBService;

@WebServlet(urlPatterns = "/ListPatients", loadOnStartup = 1)
public class ListPatients extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ListPatients() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String[] list = { "Id", "Name", "Vacaccine", "1st Dose", "2nd Dose"};
		PDBService dbService = new PDBService();
		
		request.setAttribute("pentries", dbService.getPatients());
		getServletContext().setAttribute("plist", list);
		
		
	    if (request.getSession(false) != null && request.getSession(false).getAttribute("user") != null) {
	    	request.getRequestDispatcher("/WEB-INF/ListPatients.jsp").forward(request, response);	
		} else {
			response.sendRedirect("index.jsp");
		}
		dbService.close();
	}
	
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String[] list = { "Id", "Name", "Vacaccine", "1st Dose", "2nd Dose"};
//		PDBService dbService = new PDBService();
//		request.setAttribute("pentries", dbService.getPatients());
//		getServletContext().setAttribute("plist", list);
//		dbService.close();
//		request.getRequestDispatcher("/WEB-INF/ListPatients.jsp").forward(request, response);
//	}
	
	
	
	
	
	
}
