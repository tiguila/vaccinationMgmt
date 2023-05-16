package vaccinationfiles.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vaccinationfiles.service.VDBService;

@WebServlet("/NewVaccine")
public class NewVaccine extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public NewVaccine() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vaccinemgmt/NewVaccine.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vaccineName = request.getParameter("vaccineName");
		int dosesRequired = Integer.parseInt(request.getParameter("dosesRequired"));
		int daysBetweenDoses = Integer.parseInt(request.getParameter("daysBetweenDoses"));
		VDBService dbService = new VDBService();
		dbService.addVaccine(vaccineName, dosesRequired, daysBetweenDoses);
		dbService.close();

		if (request.getSession(false) != null && request.getSession(false).getAttribute("user") != null) {
			response.sendRedirect("ListVaccines");
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
