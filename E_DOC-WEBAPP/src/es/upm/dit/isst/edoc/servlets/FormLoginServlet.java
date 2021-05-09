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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.client.ClientConfig;

//import es.upm.dit.isst.edoc
import es.upm.dit.isst.edoc.model.Alumno;
import es.upm.dit.isst.edoc.model.Professor;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String ADMIN_EMAIL = "root";
    private final String ADMIN_PASSWORD = "root"; 
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            Client client = ClientBuilder.newClient(new ClientConfig());

            // autenticacion1 -- Admin Professor 
            if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {        
                 req.getSession().setAttribute("admin", true);
                 List<Professor> professors  = client.target(URLHelper.getURL())
                        .request().accept(MediaType.APPLICATION_JSON)
                        .get(new GenericType<List<Professor>>() {});
                 req.setAttribute("professors", professors);
               getServletContext().getRequestDispatcher("/Admin.jsp")
                                  .forward(req,resp);
                return;
            }
            // autenticacion2 -- Professor
            if ( email.indexOf("@upm.es") > -1) {
                    req.getSession().setAttribute("profesor", email);
                    List<Professor> professors  = client.target(URLHelper.getURL()
                                         + "/professor/" + email)
                             .request().accept(MediaType.APPLICATION_JSON)
                             .get(new GenericType<List<Professor>>() {});
                    req.setAttribute("professors", professors);
                    getServletContext().getRequestDispatcher("/Profesor.jsp")
                                  .forward(req,resp);
                    return;
            }            

            // autenticacion3 -- ¿Alumno?
		/*
		 * TFG tfg = null; try { tfg = client.target(URLHelper.getURL() + "/" + email)
		 * .request().accept(MediaType.APPLICATION_JSON).get(TFG.class); }catch
		 * (Exception e) { } if ( null != tfg ) { req.getSession().setAttribute("tfg",
		 * tfg); getServletContext().getRequestDispatcher("/TFG.jsp").forward(req,resp);
		 * return; }
		 */
            getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
        }

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doGet(request, response); }
	 */

}