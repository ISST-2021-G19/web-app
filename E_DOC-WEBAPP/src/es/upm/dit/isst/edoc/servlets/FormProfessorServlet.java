package es.upm.dit.isst.edoc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.edoc.model.Subject;

/**
 * Servlet implementation class FormProfessorServlet
 */
@WebServlet("/FormProfessorServlet")
public class FormProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  // autorizacion
	  String email = req.getParameter("tfgemail");
	  Client client = ClientBuilder.newClient(new ClientConfig());
	  Subject subject = null;
	  try { subject = client.target(URLHelper.getURL() + "/" + email)
	              .request().accept(MediaType.APPLICATION_JSON).get(Subject.class);}
	  catch(Exception e) {}
	  if (subject != null) {
	    // autorizacion
	   /* if (subject.getStatus() == 1 || subject.getStatus() == 4 || subject.getStatus() == 6) {
	        tfg.setStatus(subject.getStatus()+1);
	        if (req.getParameter("mark") != null) {
	                String m = req.getParameter("mark").replace(",", ".");
	                tfg.setGrade(Double.parseDouble(m));
	        }
	        client.target(URLHelper.getURL()+ "/" + email).request()
	           .post(Entity.entity(tfg, MediaType.APPLICATION_JSON), Response.class);
	    }
	    List<TFG> tfgs = client.target(URLHelper.getURL() + "/professor/"+ tfg.getAdvisor())
	                                .request().accept(MediaType.APPLICATION_JSON)
	                              .get(new GenericType<List<TFG>>() {});
	    req.setAttribute("tfgs", tfgs);*/
	  }
	  getServletContext().getRequestDispatcher("/Profesor.jsp").forward(req,resp);

	}
}
