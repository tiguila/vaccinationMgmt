package vaccinationfiles.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vaccinationfiles.model.Vaccine;
import vaccinationfiles.service.PDBService;
import vaccinationfiles.service.VDBService;

@WebServlet("/AddPatient")
public class AddPatient extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddPatient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VDBService vdb = new VDBService();
		request.setAttribute("entries", vdb.getVaccines());
		vdb.close();
		request.getRequestDispatcher("/WEB-INF/AddPatient.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VDBService vdb = new VDBService();
		PDBService ps = new PDBService();
		String vaccineName = request.getParameter("vaccinename");
		String patientname = request.getParameter("patientname");
		Vaccine v = vdb.getVaccineByName(vaccineName);

		if (v.getTotalDosesLeft() > 0) {
			ps.addPatient(patientname, v.getVaccineId(), vaccineName, v.getDosesRequired(), v.getTotalDosesLeft());
			vdb.updateTotalDosesLeft(v.getVaccineId(), v.getTotalDosesLeft());
			ps.close();
		}
		
		if (request.getSession(false) != null && request.getSession(false).getAttribute("user") != null) {
			response.sendRedirect("ListPatients");	
		} else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
