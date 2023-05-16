package vaccinationfiles.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vaccinationfiles.service.VDBService;


@WebServlet("/EditVaccine")
public class EditVaccine extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditVaccine()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        int id = Integer.parseInt( request.getParameter( "id" ) );

        VDBService dbService = new VDBService();
        request.setAttribute( "entry", dbService.getVaccineById( id ) );
        dbService.close();
        
		request.getRequestDispatcher("WEB-INF/vaccinemgmt/EditVaccine.jsp").forward(request, response);
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        int id = Integer.parseInt( request.getParameter("id"));
        String vaccineName = request.getParameter( "vaccineName");
        
        int dosesRequired = Integer.parseInt( request.getParameter( "dosesRequired"));
        int daysBetweenDoses = Integer.parseInt( request.getParameter( "daysBetweenDoses"));
        
        VDBService dbService = new VDBService();
        dbService.editVaccine(id, vaccineName, dosesRequired, daysBetweenDoses);
        dbService.close();

        response.sendRedirect( "ListVaccines" );
    }
}
