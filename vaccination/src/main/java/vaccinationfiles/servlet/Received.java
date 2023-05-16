package vaccinationfiles.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vaccinationfiles.model.Patient;
import vaccinationfiles.model.Vaccine;
import vaccinationfiles.service.PDBService;
import vaccinationfiles.service.VDBService;

@WebServlet("/Received")
public class Received extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Received() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PDBService x = new PDBService();
		VDBService y = new VDBService();
		
		Patient patient = x.getPatientById(id);
		Vaccine vaccine = y.getVaccineById(patient.getVaccineId());
		
		
		
		if(vaccine.getTotalDosesLeft()>0) {
			y.updateTotalDosesLeft(patient.getVaccineId(), vaccine.getTotalDosesLeft());
			x.secondDate(patient.getPatientId());
			x.close();
			y.close();
		}
		
		
		if (request.getSession(false) != null && request.getSession(false).getAttribute("user") != null) {
			response.sendRedirect("ListPatients");
		} else {
			response.sendRedirect("index.jsp");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
