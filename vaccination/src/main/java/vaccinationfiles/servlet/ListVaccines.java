package vaccinationfiles.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import vaccinationfiles.service.VDBService;

@WebServlet(urlPatterns = "/ListVaccines", loadOnStartup = 1)
public class ListVaccines extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ListVaccines() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] list = { "Vaccine", "Doses Required", "Days Between Doses", "Total Doses Received", "Total Doses Left",
				"" };
		VDBService vdb = new VDBService();

		getServletContext().setAttribute("list", list);
		getServletContext().setAttribute("entries", vdb.getVaccines());
        
		vdb.close();
		
		if (request.getSession(false) != null && request.getSession(false).getAttribute("user") != null) {
			request.getRequestDispatcher("/WEB-INF/vaccinemgmt/ListVaccines.jsp").forward(request, response);	
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}