package vaccinationfiles.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vaccinationfiles.service.VDBService;

@WebServlet("/NewDoses")
public class NewDoses extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public NewDoses() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vaccineName = request.getParameter("vaccinename");
		VDBService dbService = new VDBService();
		request.setAttribute("entry", dbService.getVaccineByName(vaccineName));
		request.setAttribute("entries", dbService.getVaccines());
		dbService.close();
		request.getRequestDispatcher("/WEB-INF/vaccinemgmt/NewDoses.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("vaccinename");

		int newDoses = Integer.parseInt(request.getParameter("doses"));
		VDBService dbService = new VDBService();
		dbService.newDoses(id, newDoses);

		if (request.getSession(false) != null && request.getSession(false).getAttribute("user") != null) {
			response.sendRedirect("ListVaccines");
		} else {
			response.sendRedirect("index.jsp");
		}

		dbService.close();
	}
}
